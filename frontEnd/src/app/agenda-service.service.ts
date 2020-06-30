import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from 'src/app/usuario';
import { Observable } from 'node_modules/rxjs';
import { Telefono } from './telefono';
import { AppRoutingModule } from './app-routing.module';

@Injectable({
  providedIn: 'root'
})
export class AgendaServiceService {

  private agendaUrl: string;
  private listarUsuario: string;

  private crearTelefono: string;
  private listarTelefono: string;

  private recuperarTelefono: string;

  private editarContacto: string;

  private borrarContacto: string;

  constructor(private http: HttpClient) { 
    this.agendaUrl = 'http://localhost:8080/usuariospring/crear';
    this.listarUsuario='http://localhost:8080/usuario/listar';
    this.crearTelefono= 'http://localhost:8080/telefono/crear';
    this.listarTelefono= 'http://localhost:8080/telefono/listar';
    this.recuperarTelefono = 'http://localhost:8080/telefono/buscar';
    this.editarContacto = 'http://localhost:8080/telefono/actualizar';
    this.borrarContacto = 'http://localhost:8080/telefono/eliminar';
  }

  public findAll(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.listarUsuario);
  }
  
  public editar(telefono: Telefono) {
    return this.http.put<Telefono>(this.editarContacto, telefono);
  }

  public save(user: Usuario) {
 
    return this.http.post<Usuario>(this.agendaUrl, user);
  }

  public saveTelefono(telefono: Telefono) {
    console.log(telefono.usuario.nombre)
    console.log(JSON.stringify( telefono))
    return this.http.post<Telefono>(this.crearTelefono, telefono);
  }

  public findAllTelefonos(): Observable<Telefono[]> {
    return this.http.get<Telefono[]>(this.listarTelefono);
  }
  
  public buscar(id:Number) {
    return this.http.get<Telefono>(this.recuperarTelefono+"/"+id);
  }

  public eliminarContacto(telefono: Telefono) {
    return this.http.delete<Telefono>(this.borrarContacto+'/'+telefono.codigo);
  }


}




