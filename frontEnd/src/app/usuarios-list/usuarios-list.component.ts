import { Component, OnInit } from '@angular/core';
import {Usuario} from 'src/app/usuario'
import {AgendaServiceService} from 'src/app/agenda-service.service'

@Component({
  selector: 'app-usuarios-list',
  templateUrl: './usuarios-list.component.html',
  styleUrls: ['./usuarios-list.component.css']
})

export class UsuariosListComponent implements OnInit {

  users: Usuario[];

  constructor(private agendaService: AgendaServiceService) { 


  }

  ngOnInit() {
    this.agendaService.findAll().subscribe(data => {
      this.users = data;
    });
  }

}
