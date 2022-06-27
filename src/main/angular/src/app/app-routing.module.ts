import { NgModule } from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./guest/home/home.component";
import {LoginComponent} from "./guest/login/login.component";
import {RegisterComponent} from "./guest/register/register.component";
import {AdminComponent} from "./admin/admin/admin.component";
import {UnauthorizedComponent} from "./error/unauthorized/unauthorized.component";
import {NotFoundComponent} from "./error/not-found/not-found.component";
import {ProfileComponent} from "./user/profile/profile.component";
import {AuthGuard} from "./guards/auth.guard";
import {Role} from "./models/role.enum";
import {CommonModule} from "@angular/common";

const routes: Routes = [

  {path: '', redirectTo: 'home', pathMatch: 'full'},

  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},

  { path: 'profile',
    component: ProfileComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.ADMIN, Role.USER]}
    },

  { path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.ADMIN]}
  },

  {path: '404', component: NotFoundComponent},
  {path: '401', component: UnauthorizedComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
  constructor(private router: Router) {
    this.router.errorHandler = (error: any) => {
      this.router.navigate(['/404']);
    }
  }
}
