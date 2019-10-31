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

  constructor(
  ) {

    console.log('Este es el contructor del componente crear persona')
   }

  ngOnInit() {
    console.log('Este es evento se ejecurara cuando se inicie la vida del componente Crear Persona')
  }

}
