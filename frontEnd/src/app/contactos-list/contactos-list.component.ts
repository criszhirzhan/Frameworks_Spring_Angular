import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/usuario';
import {AgendaServiceService} from 'src/app/agenda-service.service'
import { Telefono } from '../telefono';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-contactos-list',
  templateUrl: './contactos-list.component.html',
  styleUrls: ['./contactos-list.component.css']
})
export class ContactosListComponent implements OnInit {

  telefonos: Telefono[];

  constructor(private userService: AgendaServiceService, private router: Router) { }

  ngOnInit(): void {
    this.userService.findAllTelefonos().subscribe(data => {
      this.telefonos = data;
    });
  }

  Editar(telefono: Telefono):void{
    localStorage.setItem("id", telefono.codigo.toString());
    this.router.navigate(['/editarContacto']);
  }

  Delete(telefono: Telefono):void{
    this.userService.eliminarContacto(telefono)
    .subscribe(data=>{
      this.telefonos=this.telefonos.filter(p=>p!==telefono);
      alert("Contacto eliminado... ");
    })
  }

}
