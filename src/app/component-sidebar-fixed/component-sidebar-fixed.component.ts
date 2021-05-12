import { Component, OnInit } from '@angular/core';
import { NbMenuItem, NbSidebarService } from '@nebular/theme';

@Component({
  selector: 'app-component-sidebar-fixed',
  templateUrl: './component-sidebar-fixed.component.html',
  styleUrls: ['./component-sidebar-fixed.component.css']
})
export class ComponentSidebarFixedComponent implements OnInit {

   items: NbMenuItem[]=[{
     title: 'Costumers',
     icon: 'grid-outline',
     target: '_blank',
     link: '/costumers'
   },
   {
    title: 'Users',
    icon: 'pricetags-outline',
    target: '_blank',
    link: '/users'
  }];
  constructor(private sidebarService: NbSidebarService) {
 
   }

  ngOnInit(): void {

  
  }


}
