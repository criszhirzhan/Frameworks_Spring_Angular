import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegistrarUsuarioComponent } from './registrar-usuario/registrar-usuario.component';
import { RegistrarContactoComponent } from './registrar-contacto/registrar-contacto.component';
import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { ContactosListComponent } from './contactos-list/contactos-list.component';
import {AgendaServiceService} from 'src/app/agenda-service.service';
import { EditarTelefonoComponent } from './editar-telefono/editar-telefono.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegistrarUsuarioComponent,
    RegistrarContactoComponent,
    UsuariosListComponent,
    ContactosListComponent,
    EditarTelefonoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AgendaServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
