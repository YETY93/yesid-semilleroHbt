import { ComicDTO } from '../../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'modificar-comic',
    templateUrl: './modificar-comic-component.html',
    styleUrls: ['./modificar-comic-component.css']
})

export class ModificarComicComponent implements OnInit {

    /**
         * Atributo que contiene los controles del formulario
         */
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic a traves del URL
     */
    public datosComicURL: ComicDTO;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb: FormBuilder,
        private activateRoute: ActivatedRoute) {

        this.gestionarComicForm = this.fb.group({
            nombre: [null, Validators.required],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al crear el componente
     * @author Yesid Rangel Orozco
     */
    ngOnInit(): void {

        this.datosComicURL = new ComicDTO();
        this.datosComicURL.id = this.activateRoute.snapshot.params.id;
        this.datosComicURL.nombre = this.activateRoute.snapshot.params.nombre;
        this.datosComicURL.editorial = this.activateRoute.snapshot.params.editorial;
        this.datosComicURL.tematica = this.activateRoute.snapshot.params.tematica;
        this.datosComicURL.coleccion = this.activateRoute.snapshot.params.coleccion;
        this.datosComicURL.numeroPaginas = this.activateRoute.snapshot.params.numeroPaginas;
        this.datosComicURL.precio = this.activateRoute.snapshot.params.precio;
        this.datosComicURL.autores = this.activateRoute.snapshot.params.autores;
        this.datosComicURL.color = this.activateRoute.snapshot.params.color;

        this.consultarComic(this.datosComicURL);

    }





    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(comic: ComicDTO): void {
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.nombre.disable();
        this.gestionarComicForm.controls.editorial.disable();
        this.gestionarComicForm.controls.tematica.disable();
        this.gestionarComicForm.controls.coleccion.disable();
        this.gestionarComicForm.controls.numeroPaginas.disable();
        this.gestionarComicForm.controls.precio.disable();
        this.gestionarComicForm.controls.autores.disable();
        this.gestionarComicForm.controls.color.disable();
        //        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Yesid Rangel
     */
    get f() {
        return this.gestionarComicForm.controls;
    }
}
