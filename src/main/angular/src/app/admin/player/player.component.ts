import { Component } from '@angular/core';
import {Player} from "../../models/player.model";
import {PlayerService} from "../../service/player/player.service";
import {Posicao} from "../../models/posicao.enum";

declare var $: any;

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent {

  player: Player = new Player();
  errorMessage: string = "";

  // public posicao = Object.values(Posicao);

  constructor(private playerService: PlayerService) { }

  savePlayer() {

    this.playerService.savePlayer(this.player).subscribe( {
        next: data => {
          $('#playerModal').modal('hide');
        },
        error: err => {
            this.errorMessage = "Unexpected error ocurred.";
            console.log(err);
        }
    })
  }

  showPlayerModal() {
    $('#playerModal').modal('show');
  }
}
