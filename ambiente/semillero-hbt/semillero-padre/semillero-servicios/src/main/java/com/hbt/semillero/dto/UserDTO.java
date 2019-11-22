/**
 * UserDTO.java
 */
package com.hbt.semillero.dto;

import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoUsuario;

/**
 * <b>Descripción:<b> Clase que determina los datos de un usuario
 * <b>Caso de Uso:<b> 
 * @author Yesid Rabgel			
 * @version 
 */
public class UserDTO {
	
	private String id ;
	private String Nombre;
	private LocalDate fechaCreacion;
	private EstadoUsuario estadoUsuario;
	private String IDpersona;
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo Nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo Nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estadoUsuario
	 * @return El estadoUsuario asociado a la clase
	 */
	public EstadoUsuario getEstadoUsuario() {
		return estadoUsuario;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estadoUsuario
	 * @param estadoUsuario El nuevo estadoUsuario a modificar.
	 */
	public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo IDpersona
	 * @return El iDpersona asociado a la clase
	 */
	public String getIDpersona() {
		return IDpersona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo IDpersona
	 * @param iDpersona El nuevo iDpersona a modificar.
	 */
	public void setIDpersona(String iDpersona) {
		IDpersona = iDpersona;
	}
	
	
	
	
	}

	
	
	
	

