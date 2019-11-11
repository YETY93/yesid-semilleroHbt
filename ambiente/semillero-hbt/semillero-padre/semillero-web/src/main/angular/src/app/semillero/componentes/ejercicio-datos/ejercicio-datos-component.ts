import { Component, OnInit } from '@angular/core';
import { RevistaDTO } from '../../dto/revista.dto';

/**
 * @description Componente contendra la logica para mostrar los datos del autor en el home 
 * 
 * @author Yesid Rangel <yety93r@gmail.com>
 */
@Component({
  // tslint:disable-next-line: component-selector
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

  // instaciacion de la revista DTO
  public listaResvistas: Array<RevistaDTO>;
  public revistaUnoDTO: RevistaDTO = new RevistaDTO();
  public revistaDosDTO: RevistaDTO;
  public revistaTresDTO: RevistaDTO;
  public revistaCuatroDTO: RevistaDTO;
  public revistaCincoDTO: RevistaDTO;

  // en el contrusctor se declaran las variables y se añadian a la lista
  constructor() {
    console.log('Entro del Componente de Ejercicio-Datos');

    console.log(this.datosEstudiante);

  }

  ngOnInit(): void {

    console.log('Entro del Ejercicio-Datos con Onint');
    this.nombreEstudiante = 'Yesid Rangel Orozco';
    this.ciudadEstudiante = 'Tunja-Boyaca';
    this.repositorioEstudiante = 'https://github.com/YETY93/yesid-semilleroHbt.git';

    this.datosEstudiante = [
      this.nombreEstudiante,
      this.ciudadEstudiante,
      this.repositorioEstudiante
    ];
    this.declararObjetos();
  }
  public declararObjetos(): void {
    this.listaResvistas = new Array<RevistaDTO>();

    this.revistaUnoDTO = {
      id: 1,
      nombre: "hola",
      editorial: "marvel",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 500.99,
      autores : "Pedrito barrera",
      aColor : true,
      fechaVenta :new Date(),
      estado : "activo",

    }
    this.revistaDosDTO = {
      id: 2,
      nombre: "hola",
      editorial: "marvel",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 500.99,
      autores : "Pedrito barrera",
      aColor : true,
      fechaVenta :new Date(),
      estado : "activo",

    }
    this.revistaTresDTO = {
      id: 3,
      nombre: "hola",
      editorial: "marvel",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 500.99,
      autores : "Pedrito barrera",
      aColor : true,
      fechaVenta :new Date(),
      estado : "activo",

    }
    this.revistaCuatroDTO = {
      id: 4,
      nombre: "hola",
      editorial: "marvel",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 500.99,
      autores : "Pedrito barrera",
      aColor : true,
      fechaVenta :new Date(),
      estado : "activo",

    }
    this.revistaCincoDTO = {
      id: 5,
      nombre: "hola",
      editorial: "marvel",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 500.99,
      autores : "Pedrito barrera",
      aColor : true,
      fechaVenta :new Date(1995,11,17),
      estado : "activo",

    }

    this.listaResvistas.push(this.revistaUnoDTO);
    this.listaResvistas.push(this.revistaDosDTO);
    this.listaResvistas.push(this.revistaTresDTO);
    this.listaResvistas.push(this.revistaCuatroDTO);
    this.listaResvistas.push(this.revistaCincoDTO);

    console.log(this.listaResvistas )
  }
}
