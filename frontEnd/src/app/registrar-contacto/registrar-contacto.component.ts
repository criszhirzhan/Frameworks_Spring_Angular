import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Telefono } from 'src/app/telefono'
import { AgendaServiceService } from 'src/app/agenda-service.service'
import { Usuario } from '../usuario';

@Component({
  selector: 'app-registrar-contacto',
  templateUrl: './registrar-contacto.component.html',
  styleUrls: ['./registrar-contacto.component.css']
})
export class RegistrarContactoComponent implements OnInit {
  telefono: Telefono;
  users: Usuario[];

  usuario:Usuario;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: AgendaServiceService) {
    this.telefono = new Telefono();
  }

  onSubmit() {
    this.userService.saveTelefono(this.telefono).subscribe(result => this.gotoContactosList);
  }

  gotoContactosList() {
    this.router.navigate(['/listarContactos']);
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }
}
