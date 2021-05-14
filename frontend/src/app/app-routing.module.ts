import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ComponentDashboardLayoutComponent} from './component-dashboard-layout/component-dashboard-layout.component';
import {AuthGuardServiceService} from './services/auth-guard-service.service'
import {UserTableComponent} from './user-table/user-table.component'
import {ComponentSmartTableComponent} from './component-smart-table/component-smart-table.component'

const routes: Routes = [
  {path: '', canActivate:[AuthGuardServiceService],component: ComponentDashboardLayoutComponent,

  children: [
    {path: '',component: ComponentSmartTableComponent},
    {path: 'users',component: UserTableComponent}
  ]



},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
