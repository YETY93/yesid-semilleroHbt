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


constructor(){
  console.log("Entro del Componente de Bienvenida");
}

  ngOnInit(): void {
    console.log("Entro del Componente de Bienvenida con Onint");
  }

}