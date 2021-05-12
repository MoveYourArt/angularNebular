import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NbSidebarModule, NbLayoutModule, NbButtonModule, NbThemeModule,NbMenuModule,NbCardModule } from '@nebular/theme';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { ComponentSmartTableComponent } from './component-smart-table/component-smart-table.component';
import { ComponentSidebarFixedComponent } from './component-sidebar-fixed/component-sidebar-fixed.component';
import { ComponentDashboardLayoutComponent } from './component-dashboard-layout/component-dashboard-layout.component';

@NgModule({
  declarations: [
   
    AppComponent,
    ComponentSmartTableComponent,
    ComponentSidebarFixedComponent,
    ComponentDashboardLayoutComponent
  ],
  imports: [
    NbThemeModule.forRoot({name: 'dark'}),
    BrowserModule,
    AppRoutingModule,
    NbLayoutModule,
    NbSidebarModule.forRoot(),
    NbButtonModule,
    NbEvaIconsModule,
    NbMenuModule.forRoot(),
    Ng2SmartTableModule,
    NbCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
