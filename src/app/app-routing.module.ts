import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NbAuthComponent } from '@nebular/auth'; 
import {ComponentDashboardLayoutComponent} from './component-dashboard-layout/component-dashboard-layout.component';
import {AuthGuardServiceService} from './services/auth-guard-service.service'

const routes: Routes = [
  {path: '', canActivate:[AuthGuardServiceService],component: ComponentDashboardLayoutComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
