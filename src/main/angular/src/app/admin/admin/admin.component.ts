import {Component, OnInit, ViewChild} from '@angular/core';
import {Player} from "../../models/player.model";
import {PlayerService} from "../../service/player/player.service";
import {PlayerComponent} from "../player/player.component";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  playList: Array<Player> = [];

  @ViewChild(PlayerComponent) child: PlayerComponent | undefined;

  constructor(private playerService: PlayerService) {

  }

  ngOnInit(): void {
    this.playerService.getAllPlayers().subscribe({
      next: data => {
        this.playList = data;
      }
    });
  }

  createPlayerRequest() {
    this.child?.showPlayerModal();
  }

}
