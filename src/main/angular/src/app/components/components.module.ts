import {NgModule} from "@angular/core";
import {NavbarComponent} from "./navbar/navbar.component";
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {FooterComponent} from "./footer/footer.component";
import {SidebarComponent} from "./sidebar/sidebar.component";
// import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  imports: [CommonModule, RouterModule],
  declarations: [NavbarComponent, FooterComponent, SidebarComponent],
  exports: [NavbarComponent, FooterComponent, SidebarComponent]
})
export class ComponentsModule {}
