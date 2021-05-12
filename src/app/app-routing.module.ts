import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {ComponentDashboardLayoutComponent} from './component-dashboard-layout/component-dashboard-layout.component';

const routes: Routes = [
  {path: '',component: ComponentDashboardLayoutComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
