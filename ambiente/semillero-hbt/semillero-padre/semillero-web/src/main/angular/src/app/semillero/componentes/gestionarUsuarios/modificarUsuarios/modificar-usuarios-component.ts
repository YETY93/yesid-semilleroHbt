import { UsuarioDTO } from '../../../dto/usuarios.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'modificar-usuarios',
    templateUrl: './modificar-usuarios-component.html',
    styleUrls: ['./modificar-usuarios-component.css']
})

export class ModificarUsuariosComponent implements OnInit {

    /**
         * Atributo que contiene los controles del formulario
         */
    public gestionarUsuariosForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic a traves del URL
     */
    public datosUsuariosURL: UsuarioDTO;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Yesid Rangel 
     */
    constructor(private fb: FormBuilder,
        private activateRoute: ActivatedRoute) {

            this.gestionarUsuariosForm = this.fb.group({
                nombre: [null, Validators.required],
                fechaCreacion: [null],
                estado: [null],
                IDpersona: [null],
            });
    }

    /**
     * @description Evento angular que se ejecuta al crear el componente
     * @author Yesid Rangel Orozco
     */
    ngOnInit(): void {

        this.datosUsuariosURL = new UsuarioDTO();
        this.datosUsuariosURL.id = this.activateRoute.snapshot.params.id;
        this.datosUsuariosURL.nombre = this.activateRoute.snapshot.params.nombre;
        this.datosUsuariosURL.estado = this.activateRoute.snapshot.params.editorial;
        this.datosUsuariosURL.fechaCreacion = this.activateRoute.snapshot.params.tematica;
        this.datosUsuariosURL.IDpersona = this.activateRoute.snapshot.params.tematica;


        this.consultarComic(this.datosUsuariosURL);

    }





    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del Usuario seleccionado
     */
    public consultarComic(user: UsuarioDTO): void {
        this.gestionarUsuariosForm.controls.nombre.setValue(user.nombre);
        this.gestionarUsuariosForm.controls.estado.setValue(user.estado);
        this.gestionarUsuariosForm.controls.fechaCreacion.setValue(user.fechaCreacion);
        this.gestionarUsuariosForm.controls.IDpersona.setValue(user.IDpersona);
        
        this.gestionarUsuariosForm.controls.nombre.disable();
        this.gestionarUsuariosForm.controls.estado.disable();
        this.gestionarUsuariosForm.controls.fechaCreacion.disable();
        this.gestionarUsuariosForm.controls.IDpersona.disable();
        //        this.gestionarUsuariosForm.controls.IDpersona; para habilitar el campo

    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Yesid Rangel
     */
    get f() {
        return this.gestionarUsuariosForm.controls;
    }
}
