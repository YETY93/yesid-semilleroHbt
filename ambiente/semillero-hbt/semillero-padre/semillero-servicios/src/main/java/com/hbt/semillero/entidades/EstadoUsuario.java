/**
 * EstadiUsuario.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina el estado de un Usuario
 * <b>Caso de Uso:<b> 
 * @author Yesid Range
 * @version 
 */
public enum EstadoUsuario {
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo");
	
	private String MensajeEstado;
	
	/**
	 * Constructor de la clase.
	 * @param mensajeEstado
	 */
	
	private EstadoUsuario( String mensajeEstado ) {
		MensajeEstado = mensajeEstado;
		
	}

	/**
	 * Metodo encargado de retornar el valor del atributo MensajeEstado
	 * @return El mensajeEstado asociado a la clase
	 */
	public String getMensajeEstado() {
		return MensajeEstado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo MensajeEstado
	 * @param mensajeEstado El nuevo mensajeEstado a modificar.
	 */
	public void setMensajeEstado(String mensajeEstado) {
		MensajeEstado = mensajeEstado;
	}
	

}
