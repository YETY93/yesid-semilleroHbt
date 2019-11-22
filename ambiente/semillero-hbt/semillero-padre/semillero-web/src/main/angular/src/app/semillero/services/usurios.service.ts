import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from './template.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UsuarioDTO } from '../dto/usuarios.dto';



const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

/**
 * Servicio encargado de llamar a los servicios REST de
 * ejemplo
 */
@Injectable({
  providedIn: 'root'
})
export class UsuariosService extends AbstractService {

    private urlback = 'http://localhost:8085/semillero-servicios/rest/';
    private urlbackUsers = `${this.urlback}GestionarUser/`;

  /**
   * Constructor
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    super(injector);
  }

  consultarUserios():Observable<any>{
    return this.httpClient.get<UsuarioDTO>(`${this.urlbackUsers}`, httpOptions);
    
  }

  getUser(id:string):Observable<any>{
    return this.httpClient.get<UsuarioDTO>(`${this.urlbackUsers}${id}/consultarUser`, httpOptions);
  }

  addUser(usuarioDTO:UsuarioDTO):Observable<any>{
    let body = JSON.stringify( usuarioDTO );
    console.log (body);
    return this.httpClient.post( `${this.urlbackUsers}/crear`, body , httpOptions);
  }

  editUser( usuarioDTO:UsuarioDTO, id:string):Observable<any>{
    let body = JSON.stringify(usuarioDTO);
    return this.httpClient.put(`${this.urlbackUsers}${id}/modificar`,body, httpOptions);
  }
  
  deletUser(id):Observable<any>{
    return this.httpClient.delete(`${this.urlbackUsers}${id}/elimina`,httpOptions);
    }
}