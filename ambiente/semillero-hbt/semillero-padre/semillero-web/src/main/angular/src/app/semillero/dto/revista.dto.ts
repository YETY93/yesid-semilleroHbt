/**
 * @description Clase revista que contiene la informacion y los
 * datos de una revista
 * 
 * @author Yesid Rangel
 */
export class RevistaDTO {


    /**
    * Indicador de resultado.
    */
    public id: number;

    /**
    * Indicador de resultado.
    */
    public nombre: string;

    /**
    * Indicador de resultado.
    */
    public editorial: string;

    /**
    * Indicador de resultado.
    */
    public tematica: string;

    /**
    * Indicador de resultado.
    */
    public numeroPaginas: number;

    /**
    * Indicador de resultado.
    */
    public precio: number;

    /**
    * Indicador de resultado.
    */
    public autores: string;

    /**
    * Indicador de resultado.
    */
    public aColor: boolean;

    /**
    * Indicador de resultado.
    */
    public fechaVenta: Date;

    /**
    * Indicador de resultado.
    */
    public estado: string;
}