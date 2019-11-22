import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { UsuarioDTO } from '../../dto/usuarios.dto';
import { UsuariosService } from '../../services/usurios.service';

/**
 * @description Componenete gestionar usuarios, el cual contiene la logica CRUD
 * 
 * @author Yesid rangel
 */
@Component({
    selector: 'gestionar-usuarios',
    templateUrl: './gestionar-usuarios.html',
    styleUrls: ['./gestionar-usuarios.css']
})

export class GestionarUsuariosComponent implements OnInit {


    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarUsuariosForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public usuario: UsuarioDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaUsuarios: Array<UsuarioDTO>;

    /**
     *  atributo que indica si se envio a editar un comic
     */
    public editar: boolean;
    /**
  *  atributo que almacena el comic que se va a edita
  */
    public userioEditar: number;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;
    /**
 * Atributo que indica el Comic eliminado
 */
    public usuarioEliminado: string;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */


    constructor(private fb: FormBuilder,
        private router: Router,
        private usuariosService: UsuariosService) {
        this.gestionarUsuariosForm = this.fb.group({
            nombre: [null, Validators.required],
            fechaCreacion: [null],
            estado: [null],
            IDpersona: [null],
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Yesid Rangel
     */

    ngOnInit(): void {
        this.userioEditar = null;
        this.usuario = new UsuarioDTO();
        this.listaUsuarios = new Array<UsuarioDTO>();
        this.traerUSuarios();
    }


    public traerUSuarios(): void {
        this.usuariosService.consultarUserios().subscribe( listadoUsuarios =>{
            if (listadoUsuarios.code != 200) {
                window.location.reload();
              } else {
                this.listaUsuarios = listadoUsuarios.data;
              }
            }, error => {
              console.log(<any>error);
            });
    }

    public crearActualizarUsuario(): void {
        this.submitted = true;
        if (this.gestionarUsuariosForm.invalid) {
            return;
        } else if ((this.userioEditar != null)) {
            this.listaUsuarios[this.userioEditar].nombre = this.gestionarUsuariosForm.controls.nombre.value;
            this.listaUsuarios[this.userioEditar].fechaCreacion = this.gestionarUsuariosForm.controls.fechaCreacion.value;
            this.listaUsuarios[this.userioEditar].estado = this.gestionarUsuariosForm.controls.estado.value;
            this.listaUsuarios[this.userioEditar].IDpersona = this.gestionarUsuariosForm.controls.IDpersona.value;
            this.limpiarFormulario();
        }
    }
    /**
     * @description metodo que ejecuta la consulta de un Usuario detallado
     * @author Yesid Rangel
     */
    public consultarUsuario(posicion: number): void {
       
        this.usuariosService.getUser(posicion.toString()).subscribe(dataresp =>{

            let usuario = dataresp;
            this.gestionarUsuariosForm.controls.nombre.setValue(usuario.nombre);
            this.gestionarUsuariosForm.controls.fechaCreacion.setValue(usuario.fechaCreacion);
            this.gestionarUsuariosForm.controls.estado.setValue(usuario.estado);
            this.gestionarUsuariosForm.controls.IDpersona.setValue(usuario.IDpersona);
            this.gestionarUsuariosForm.controls.nombre.disable();
            this.gestionarUsuariosForm.controls.fechaCreacion.disable();
            this.gestionarUsuariosForm.controls.estado.disable();
            this.gestionarUsuariosForm.controls.IDpersona.disable();
            this.gestionarUsuariosForm.controls.fechaCreacion.disable();

        });
        this.limpiarFormulario();

    }

    /**
    * Metodo que permite consultar un comic de la tabla y ver sus detalles  el formulario
    * @param posicion en la lista del usuario seleccionado
    */
    public editarUsuario(posicion: number): void {
        let usuario = this.listaUsuarios[posicion];
        this.userioEditar = this.listaUsuarios.indexOf(usuario);
        this.editar = true;
        this.gestionarUsuariosForm.controls.nombre.setValue(usuario.nombre);
        this.gestionarUsuariosForm.controls.nombre.setValue(usuario.fechaCreacion);
        this.gestionarUsuariosForm.controls.nombre.setValue(usuario.estado);
        this.gestionarUsuariosForm.controls.nombre.setValue(usuario.IDpersona);
    
    }



    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarUsuariosForm.reset();
        this.editar = false;
    }

    /**
     * @description Metodo encargadod de eliminar un item de la lista
     * @author Yesid Rangel
     */
    public eliminarComic(posicion: number) {
        this.usuario = this.listaUsuarios[posicion];
        this.usuarioEliminado = this.usuario.nombre;
        this.listaUsuarios.splice(posicion, 1);

    }
    /**
 * @description Metodo que obtiene los controles y sus propiedades
 * @author Yesid Rangel
 */
    get f() {
        return this.gestionarUsuariosForm.controls;
    }

}
