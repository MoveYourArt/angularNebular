import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ng2SmartTableModule, LocalDataSource } from 'ng2-smart-table';

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {

  data=[{
    id: '',
    userName:'',
    password:'',
    email:'',
    role: ''
   }]

   source: LocalDataSource;
  constructor(private http: HttpClient) {
    this.http.get<any>('/users').subscribe(data1 => {

      this.data.pop();
      data1.forEach((element: { roles: any[]; id: any; userName: any; password: any; email: any; }) => {

        console.log(element.roles[0]);
        let role=element.roles[0];

        

        this.data.push({
          id: element.id,
          userName: element.userName,
          password: element.password,
          email: element.email,
          role: role.name
      })

      this.source = new LocalDataSource(this.data);
        
      });



      
    })

    this.source = new LocalDataSource(this.data);

   }

  ngOnInit(): void {
  }


  settings = {
    delete:{
    confirmDelete:false,
    deleteButtonContent: '<span>&#128465;&#65039;</span>',
    },
    add:{
      confirmAdd:false,
      addButtonContent: '<span>&#10010;</span>',
      createButtonContent: '<span>&#10004;</span>',
      cancelButtonContent: '<span>&#10006;</span>',
      },
      edit:{
        confirmSave:false,
        editButtonContent: '<span>&#9998;</span>',
        saveButtonContent: '<span>&#10004;</span>',
        cancelButtonContent: '<span>&#10006;</span>',
        },
    columns: {
   
      id: {
        title: 'ID',
        filter: false,
      },
      userName: {
        title: 'Username',
        filter: false,
      },
      password: {
        title: 'Password',
        filter: false,
      },
      email: {
        title: 'E-Mail',
        filter: false,
      },
      role:{
        title: 'Role',
        filter: false,

      },
    },
  };
    
  


  onSearch(query: string = '') {
    this.source.setFilter([
      // fields we want to inclue in the search
      {
        field: 'id',
        search: query,
      },
      {
        field: 'userName',
        search: query,
      },
      {
        field: 'password',
        search: query,
      },
      {
        field: 'email',
        search: query,
      },
      {
        field: 'role',
        search: query,
      },
    ], false);

  }

}
