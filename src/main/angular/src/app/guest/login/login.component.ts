import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user.model";
import {faUserCircle} from "@fortawesome/free-solid-svg-icons";
import {AuthenticationService} from "../../service/authentication/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  faUser = faUserCircle;
  errorMessage: string = "";

  constructor(private authenticationService: AuthenticationService, private router: Router) {

  }

  ngOnInit(): void {
    if(this.authenticationService.currentUserValue?.id) {
      this.router.navigate(['/profile']);
      return;
    }
  }

  login() {
    //DEPRECATED
    // this.authenticationService.login(this.user).subscribe(data => {
    //   this.router.navigate(['/profile']);
    // }, error => {
    //   this.errorMessage = 'Username or password is incorrect.';
    //   console.log(error);
    // })

    this.authenticationService.login(this.user).subscribe({
        next: data => {this.router.navigate(['/profile'])},
        error: err => {
          this.errorMessage = 'Username or password is incorrect.';
          console.log(err);
          }
      }
    )
  }

}
