/**
 * IGestionarUserLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.UserDTO;

/**
 * Expone los métodos del EJB GestionarUser Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Yesid Rangel
 * @version 
 */
public interface IGestionarUserLocal {

	/**
	 * 
	 * Metodo encargado de crear un comic y persistirlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicNuevo informacion nueva a crear
	 */
	public void crearUser(UserDTO userNuevo);

	/**
	 * 
	 * Metodo encargado de consultar un comic modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicModificar informacion nueva a modificar
	 */
	public void modificarUser(Long id, String nombre, UserDTO userNuevo);

	/**
	 * 
	 * Metodo encargado de eliminar un comic modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicEliminar informacion a eliminar
	 */
	public void eliminarUser(Long idUser);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un comic
	 * 
	 * @param idComic identificador del comic a ser consultado
	 * @return comic Resultado de la consulta
	 * @throws Exception si no se recibe idComic
	 */
	public UserDTO consultarUser(String idComic);

	/**
	 * 
	 * Metodo encargado de retornar una lista de comics
	 * 
	 * @return
	 */
	public List<UserDTO> consultarUser();


}
