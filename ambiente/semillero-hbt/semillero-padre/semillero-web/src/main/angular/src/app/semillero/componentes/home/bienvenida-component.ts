import { Component, OnInit } from '@angular/core';

/**
 * @description Componente bienvenida, el cual contiene la imagen de bienvenida al semillero
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
  selector: 'bienvenida',
  templateUrl: './bienvenida-component.html',
})
export class BienvenidaComponent implements OnInit {
  // variable que permitira ocultar la imagen de inicio
  public mostrarImagen: boolean;

  constructor() {
    console.log("Entro del Componente de Bienvenida");
  }

  ngOnInit(): void {
    console.log("Entro del Componente de Bienvenida con Onint");

    //la imagen se mostrara por defecto
    this.mostrarImagen = true;

  }
  //Metodo que permitira mostrar la imagen 
  public verImagen(): void {
    this.mostrarImagen = false;

  }
  //Metodo que permitira mostrar la imagen 
  public ocultarImagen(): void {
    this.mostrarImagen = true;
  }
}