/**
 * GestionarUserRest.java
 */
package com.hbt.semillero.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UserDTO;
import com.hbt.semillero.ejb.IGestionarUserLocal;

/**
 * <b>Descripción:<b> Clase que determina los servicios rest
 * <b>Caso de Uso:<b> 
 * @author Nuevo
 * @version 
 */
@Path("/GestionarComic")
public class GestionarUserRest {
	
	private IGestionarUserLocal gestionarUserEJB;
	
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComic?idComic=1
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if (idComic != null) {
			UserDTO UserDTO = gestionarUserEJB.consultarUser(idComic.toString());
			return UserDTO;
		}
		return null;
	}

	
	
	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/crear
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearUser(UserDTO userDTO) {
		gestionarUserEJB.crearUser(userDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "User creado exitosamente");
		return resultadoDTO;
		
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre de un comic
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar?idComic=1&nombre=nuevonombre
	 * @param idComic identificador del comic a buscar
	 * @param nombre nombre nuevo del comic
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificaUser(@QueryParam("idComic") Long idComic, @QueryParam("nombre") String nombre) {
		gestionarUserEJB.modificarUser(idComic, nombre, null);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic dado el id
	 * 
	 * @param idComic identificador del comic
	 */
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarComic(@QueryParam("idComic") Long idComic) {
		if (idComic != null) {
			UserDTO userDTO = gestionarUserEJB.consultarUser(idComic.toString());

		}
	}

}
