import { Component, OnInit } from '@angular/core';
import { Ng2SmartTableModule, LocalDataSource } from 'ng2-smart-table';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-component-smart-table',
  templateUrl: './component-smart-table.component.html',
  styleUrls: ['./component-smart-table.component.css']
})
export class ComponentSmartTableComponent implements OnInit {

   data=[{
    id: '',
    firstname:'',
    lastname:'',
    birthdate:'',
    address: ''
   }]

   source: LocalDataSource;
  constructor(private http: HttpClient) { 

    this.http.get<any>('/api/customers').subscribe(data1 => {

      this.data.pop();
      data1.forEach((element: { addressList: any[]; id: any; fname: any; lname: any; birthdate: any; }) => {

        console.log(element.addressList[0]);
        let addresses=element.addressList[0];

        

        this.data.push({
          id: element.id,
          firstname: element.fname,
          lastname: element.lname,
          birthdate: element.birthdate,
          address: addresses.stree+' '+ addresses.zipcode+' '+ addresses.city
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
      firstname: {
        title: 'First Name',
        filter: false,
      },
      lastname: {
        title: 'Last Name',
        filter: false,
      },
      birthdate: {
        title: 'Birthdate',
        filter: false,
      },
      address:{
        title: 'Addres',
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
        field: 'firstname',
        search: query,
      },
      {
        field: 'lastname',
        search: query,
      },
      {
        field: 'birthdate',
        search: query,
      },
    ], false);

  }

}
