import { Component, OnInit } from '@angular/core';

/**
 * @description Componente contendra la logica para mostrar los datos del autor en el home 
 * 
 * @author Yesid Rangel <yety93r@gmail.com>
 */
@Component({
  selector: 'ejercicio-datos',
  templateUrl: './ejercicio-datos-component.html',
  styleUrls: ['./ejercicio-datos-component.css']
})
export class EjercicioDatosComponent implements OnInit {
// aca se definiran las variables a trabajar
    public datosEstudiante: string[];
    public nombreEstudiante: string;
    public ciudadEstudiante: string;
    public repositorioEstudiante: string;


    // en el contrusctor se declaran las variables y se añadian a la lista
constructor(){
  console.log('Entro del Componente de Ejercicio-Datos');
  

    this.nombreEstudiante = 'Yesid Rangel Orozco';
    this.ciudadEstudiante = 'Tunja-Boyaca';
    this.repositorioEstudiante = 'https://github.com/YETY93/yesid-semilleroHbt.git';

    this.datosEstudiante = [
        this.nombreEstudiante,
        this.ciudadEstudiante,
        this.repositorioEstudiante
    ]

console.log(this.datosEstudiante)

  
  
}

  ngOnInit(): void {
    console.log('Entro del Ejercicio-Datos con Onint');
  }


  

}