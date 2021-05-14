import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NbSidebarModule, NbLayoutModule, NbButtonModule, NbThemeModule,NbMenuModule,NbCardModule } from '@nebular/theme';
import { NbPasswordAuthStrategy, NbAuthModule } from '@nebular/auth';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { ComponentSmartTableComponent } from './component-smart-table/component-smart-table.component';
import { ComponentSidebarFixedComponent } from './component-sidebar-fixed/component-sidebar-fixed.component';
import { ComponentDashboardLayoutComponent } from './component-dashboard-layout/component-dashboard-layout.component';
import { FormsModule } from '@angular/forms';
import { UserTableComponent } from './user-table/user-table.component';

@NgModule({
  declarations: [
   
    AppComponent,
    ComponentSmartTableComponent,
    ComponentSidebarFixedComponent,
    ComponentDashboardLayoutComponent,
    UserTableComponent
 
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    NbThemeModule.forRoot({name: 'dark'}),
    BrowserModule,
    AppRoutingModule,
    NbLayoutModule,
    NbSidebarModule.forRoot(),
    NbButtonModule,
    NbEvaIconsModule,
    NbMenuModule.forRoot(),
    Ng2SmartTableModule,
    NbCardModule,
    NbAuthModule.forRoot({
      strategies: [
        NbPasswordAuthStrategy.setup({
          name: 'email',
          baseEndpoint: 'http://localhost:8080',
          login:  {
            alwaysFail: false,
            endpoint: '/login',
            method: 'post',
            redirect: {
              success: '/costumers',
              failure: null,
            },

          }
      
        }),
      ],
      forms: { },
    }), 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
