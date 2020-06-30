import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/usuario'
import { AgendaServiceService } from 'src/app/agenda-service.service'

@Component({
  selector: 'app-registrar-usuario',
  templateUrl: './registrar-usuario.component.html',
  styleUrls: ['./registrar-usuario.component.css']
})
export class RegistrarUsuarioComponent implements OnInit {

  user: Usuario;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: AgendaServiceService) {
    this.user = new Usuario();
  }

  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.gotoUserList()
    );
  }

  gotoUserList() {
    this.router.navigate(['/listarUsuarios']);
  }

  ngOnInit() {

  }

}
