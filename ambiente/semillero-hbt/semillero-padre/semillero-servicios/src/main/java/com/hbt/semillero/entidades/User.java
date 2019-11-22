/**
 * User.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.ws.rs.Encoded;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar la
 * tabla "DB_SEMILLERO"."TC_USUARIO"
 * <b>Caso de Uso:<b> 
 * @author Yesid Rangel
 * @version 
 */

@Entity
@Table(name = "TC_USUARIO")
public class User implements Serializable {

	/**
	 * Atributo que de la clase
	 */
	private static final long serialVersionUID = 1L;
	private Long id ;
	private String Nombre;
	private LocalDate fechaCreacion;
	private EstadoUsuario estadoUsuario;
	private String IDpersona;
	
	
	/**
	 * Constructor de la clase.
	 */
	
	public User() {
		
	}


	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "TC_USUARIO_SUID_GENERATOR", sequenceName = "SEQ_TC_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TC_USUARIO_SUID_GENERATOR")
	@Column(name = "SUID" )
	public Long getId() {
		return id;
	}


	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo Nombre
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SUNOMBRE" )
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
	@Column(name = "SUFECHA_CREACION" )
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
	@Column(name = "SUESTADO" )
	@Enumerated(value = EnumType.STRING)
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
	@Column(name = "SUIDPERSONA" )
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


	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", Nombre=" + Nombre + ", fechaCreacion=" + fechaCreacion + ", estadoUsuario="
				+ estadoUsuario + ", IDpersona=" + IDpersona + "]";
	}


	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDpersona == null) ? 0 : IDpersona.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((estadoUsuario == null) ? 0 : estadoUsuario.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (IDpersona == null) {
			if (other.IDpersona != null)
				return false;
		} else if (!IDpersona.equals(other.IDpersona))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (estadoUsuario != other.estadoUsuario)
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	

}
