import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RegistrarUsuarioComponent} from './registrar-usuario/registrar-usuario.component';
import {RegistrarContactoComponent} from './registrar-contacto/registrar-contacto.component';
import {UsuariosListComponent} from './usuarios-list/usuarios-list.component';
import {ContactosListComponent} from './contactos-list/contactos-list.component';
import {EditarTelefonoComponent} from './editar-telefono/editar-telefono.component';


const routes: Routes = [
  {path:'',component:HomeComponent} ,
  {path:'registrarUsuario',component:RegistrarUsuarioComponent} ,
  {path:'home',component:HomeComponent},
  {path: 'registrarContacto', component:RegistrarContactoComponent},
  {path: 'listarUsuarios', component:UsuariosListComponent},
  {path: 'listarContactos', component:ContactosListComponent},
  {path: 'editarContacto', component:EditarTelefonoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
