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
  public revistaUnoDTO: RevistaDTO;
  public revistaDosDTO: RevistaDTO;
  public revistaTresDTO: RevistaDTO;
  public revistaCuatroDTO: RevistaDTO;
  public revistaCincoDTO: RevistaDTO;

  //seccion de elimanar varibale boleana
  public mostrarSeccionEliminar: boolean;
  public revistaPendiente: boolean;
  public revistaEliminada: RevistaDTO;
  // Variable que determina el id de la revista que se elminira
  public modelID: number;



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
      nombre: "capitan america",
      editorial: "marvel",
      tematica: "accion",
      numeroPaginas: 24,
      precio: 328.99,
      autores: "Pedrito barrera",
      aColor: true,
      fechaVenta: new Date(2019, 1, 16),
      estado: "activo",

    };
    this.revistaDosDTO = {
      id: 2,
      nombre: "Dinastia",
      editorial: "Panini Comics ",
      tematica: "accion",
      numeroPaginas: 56,
      precio: 155.70,
      autores: "Jonathan Hickman, Pepe Larraz",
      aColor: true,
      fechaVenta: new Date(2019, 8, 7),
      estado: "activo",

    };
    this.revistaTresDTO = {
      id: 3,
      nombre: "Amistoso vecino Spiderman",
      editorial: "marvel comic",
      tematica: "accion",
      numeroPaginas: 48,
      precio: 500.99,
      autores: "Ken Lashley, Tom Taylor ",
      aColor: true,
      fechaVenta: new Date(2015, 5, 15),
      estado: "activo",

    };
    this.revistaCuatroDTO = {
      id: 4,
      nombre: "La espada salvaje de conan",
      editorial: "Panini Comics ",
      tematica: "accion",
      numeroPaginas: 39,
      precio: 350.99,
      autores: "Jim Zub, Luke Ross, Meredith Finch, Patch Zircher",
      aColor: true,
      fechaVenta: new Date(2010, 11, 16),
      estado: "activo",

    };
    this.revistaCincoDTO = {
      id: 5,
      nombre: "Thor 14",
      editorial: "Panini Comics",
      tematica: "aventura",
      numeroPaginas: 50,
      precio: 400.99,
      autores: "Jason Aaron, Michael Del Mundo",
      aColor: true,
      fechaVenta: new Date(1995, 11, 17),
      estado: "activo",

    };

    this.listaResvistas.push(this.revistaUnoDTO);
    this.listaResvistas.push(this.revistaDosDTO);
    this.listaResvistas.push(this.revistaTresDTO);
    this.listaResvistas.push(this.revistaCuatroDTO);
    this.listaResvistas.push(this.revistaCincoDTO);

    // Esta sera varible que permitira mostrar la
    // seccion de elinar la revista 3
    this.mostrarSeccionEliminar = false;
    this.revistaPendiente = false;

    console.log(this.listaResvistas);
  }
  public publicActivarEliminar(): void {
    this.mostrarSeccionEliminar = true;

  }

  // este metodo eliminara el item de la lista segun
  //las validacione del metodo mostrarEliminacion()

  public eliminarItem(): void {

    let idPosicion = this.modelID - 1;
    this.listaResvistas.splice(idPosicion, 1);
    this.revistaPendiente = false;
    this.revistaEliminada = null;
    console.log(this.listaResvistas);

  }


  // este metodo se encargara de validad si si el valor ingreaso es numero
  public mostrarEliminacion(idRevista: number): void {

    try {
      if (isNaN(idRevista)) {

        alert('El valor ingresado ,no es un número valido');
        this.revistaPendiente = false;
        // esta seccion validadara que el numero ingresado se mayor a 0
      } else if ((idRevista > 0)) {
        this.revistaPendiente = true;
        idRevista = idRevista - 1;
        let existeID: boolean;
        /*esta seccion iterara  sobre las propiedades del objeto
         * y revisara el id conincida con el del objeto
         */
        for (let dto of this.listaResvistas) {

          if (idRevista == (dto.id - 1)) {
            existeID = true;
            idRevista = dto.id - 1;
            if (existeID) {
              console.log(idRevista + " id revista")
              this.revistaEliminada = this.listaResvistas[idRevista];
            } else {
              alert('El ID no existe se ha colocado el valor por omision')
              this.revistaEliminada = this.listaResvistas[0];
            }

            break;
          } else {
            existeID = false;
          }
        } idRevista = 0;
        if (existeID == false) {
          alert('El ID ingresado sobre pasa la cantidad de revistas');
          this.revistaPendiente = false;
          this.revistaEliminada = null;
        }
      } else {
        alert('El ID ingresado no es valido ');
        this.revistaPendiente = false;
      }
    } catch (error) {
      alert('El ID ingresado no es valido o la revista no existe');
    }

  }

}

