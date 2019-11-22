
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics: Array<ComicDTO>;

    public idComic: number = 0;
    /**
     *  atributo que almacena el comic que se va a edita
     */
    public ComicEditar: number;

    /**
     *  atributo que indica si se envio a editar un comic
     */
    public editar: boolean;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;
        /**
     * Atributo que indica el Comic eliminado
     */
    public comicEliminado: string;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb: FormBuilder,
        private router: Router) {
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
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        this.ComicEditar = null;
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic(): void {
        this.submitted = true;
        if (this.gestionarComicForm.invalid) {
            return;
        } else if ((this.ComicEditar != null)) {

            this.listaComics[this.ComicEditar].nombre = this.gestionarComicForm.controls.nombre.value;
            this.listaComics[this.ComicEditar].editorial = this.gestionarComicForm.controls.editorial.value;
            this.listaComics[this.ComicEditar].tematica = this.gestionarComicForm.controls.tematica.value;
            this.listaComics[this.ComicEditar].coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.listaComics[this.ComicEditar].numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.listaComics[this.ComicEditar].precio = this.gestionarComicForm.controls.precio.value;
            this.listaComics[this.ComicEditar].autores = this.gestionarComicForm.controls.autores.value;
            this.listaComics[this.ComicEditar].color = this.gestionarComicForm.controls.color.value;
            this.limpiarFormulario();
            this.ComicEditar = null;
        } else {
            this.idComic++;
            this.comic = new ComicDTO();
            this.comic.id = this.idComic + "";
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;

            this.listaComics.push(this.comic);
            this.limpiarFormulario();

        }

    }





    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion: number): void {
        let comic = this.listaComics[posicion];
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
 * Metodo que permite consultar un comic de la tabla y ver sus detalles  el formulario
 * @param posicion en la lista del comic seleccionado
 */
    public editarComic(posicion: number): void {
        let comic = this.listaComics[posicion];
        this.ComicEditar = this.listaComics.indexOf(comic);
        this.editar = true;
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.nombre.enable();
        this.gestionarComicForm.controls.editorial.enable();
        this.gestionarComicForm.controls.tematica.enable();
        this.gestionarComicForm.controls.coleccion.enable();
        this.gestionarComicForm.controls.numeroPaginas.enable();
        this.gestionarComicForm.controls.precio.enable();
        this.gestionarComicForm.controls.autores.enable();
        this.gestionarComicForm.controls.color.enable();
        this.ComicEditar = posicion;


    }

    // public editarComic(comic : any) : void {
    //     this.router.navigate(['bienvenida',comic]);
    // }

    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.reset();
        this.editar = false;
    }

    /**
     * @description Metodo encargadod de eliminar un item de la lista
     * @author Yesid Rangel
     */
    public eliminarComic(posicion: number) {
        this.comic = this.listaComics[posicion];
        this.comicEliminado = this.comic.nombre;
        this.listaComics.splice(posicion, 1);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.gestionarComicForm.controls;
    }
}
