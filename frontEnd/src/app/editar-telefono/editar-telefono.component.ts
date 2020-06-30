import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AgendaServiceService } from 'src/app/agenda-service.service';
import { Telefono } from 'src/app/telefono';

@Component({
  selector: 'app-editar-telefono',
  templateUrl: './editar-telefono.component.html',
  styleUrls: ['./editar-telefono.component.css']
})
export class EditarTelefonoComponent implements OnInit {

  telefono: Telefono;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: AgendaServiceService) {
    this.telefono = new Telefono();
  }

  ngOnInit() {
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.userService.buscar(+id)
    .subscribe(data => {
      this.telefono=data;
    })
  }
  Actualizar(telefono:Telefono){
    this.userService.editar(telefono)
    .subscribe(data=> {
      this.telefono=data;
      alert("Se actualizo en exito...!!!");
      this.router.navigate(["/listarContactos"])
    })
  }

}
