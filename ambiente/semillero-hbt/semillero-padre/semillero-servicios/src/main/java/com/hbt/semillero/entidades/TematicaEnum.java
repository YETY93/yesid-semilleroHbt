/**
 * TematicaEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina la enumeracion de tematica
 * <b>Caso de Uso:<b> 
 * @author Yesid Rangel
 * @version 
 */
public enum TematicaEnum {

	
	AVENTURAS ("enum.tematica.aventuras"),
	BELICO ("enum.tematica.belico"),
	HUMORISTICO ("enum.tematica.humoristico"),
	DEPORTIVO ("enum.tematica.deportivo"),
	FANTASTICO ("enum.tematica.fanctastico"),
	CIENCIA_FICCION ("enum.tematica.cienci_ficcion"), 
	HISTORICO ("enum.tematica.historico"),
	HORROR ("enum.tematica.horror");
	
	private String CodigoMensaje;

	/**
	 * Constructor de la clase.
	 * @param codigoMensaje
	 */
	private TematicaEnum(String codigoMensaje) {
		CodigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo CodigoMensaje
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return CodigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo CodigoMensaje
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		CodigoMensaje = codigoMensaje;
	}
	
	
	
}
