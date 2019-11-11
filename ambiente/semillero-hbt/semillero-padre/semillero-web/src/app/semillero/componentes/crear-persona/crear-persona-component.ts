import { Component, OnInit } from '@angular/core';
/**
 * @description Componente contendra la logica para crear la logica de una persona
 * 
 * @author Yesid Rangel <yety93r@gmail.com>
 */
@Component({
  selector: 'crear-persona',
  templateUrl: './crear-persona-component.html',
  styleUrls: ['./crear-persona-component.css']
})
export class CrearPersonaComponent implements OnInit {

  //Definición de variables globales
  private nombreInstructorGlobalPrivado: string;
  public nombreInstructorGlobalPublic: string;

  public listaApellidos: Array<any>;
  public listaNombres: [];

  //Metodo constructor de la clase
  constructor() {

    console.log('Este es el contructor del componente crear persona');
  }

  ngOnInit(): void {
    console.log('Este es evento se ejecurara cuando se inicie la vida del componente Crear Persona');

    //Definicion de variables de ejemplo
    //para los tipos de datos
    this.listaApellidos = new Array();
    this.listaApellidos.push('hola');
    this.listaApellidos.splice(1, 1); // Elimina datos desde el origen por rangos
    this.listaApellidos = []; // vacia la lista segun la declaracion vacio

    //utilizacion de la palabra resevada led
    let nombreInstructor = 'Diego Alvarez';
    let nombreInstructorSting: String = 'Diego Alvarez String';

    // declaracion de un tipo any
    let mivariable: any = {
      id: 1,
      nombre: 'Carlos',
      direccion: 'Carrera 21 este',
      colores: ['verde', 'azul', 'amarillo']
    };
    mivariable.genero = 'Masculino';

    // tipos de datos number 
    let VAriableNumerica: number = 100.23;
    // tipos de datos string 
    let variable: String = 'Semillero2019';

  }

  public inicializarComponente() : Array<string> {
    let retorno : any;
    let objeto = undefined;
    if(objeto !== null) {
        console.log('No es nulo')
    } else {
        console.log('Si es nulo');
    }

/*     console.log(1 == 1);
    console.log('1' == 1);
    console.log(1 === 1);
    console.log('1' === 1); */
    return retorno;
}
}
