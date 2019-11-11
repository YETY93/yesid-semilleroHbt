/**
 * GestinarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Yesid Ragel
 * @version
 */
@Stateless
public class GestinarComicBean implements IGestionarComicLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) // cre una nueva transaccion
	public void crearComic(ComicDTO comicDTO) {
		
		Comic comic = convertirComicDTOtoComic(comicDTO);
		em.persist(comic);
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicDTO ) {
		Comic comic = new Comic();
		//comic.setId(comicDTO.getId());
		 /**
	      * TODO 
	      * llenar el resto de los datos
	      */
		em.merge(comic);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class, id);
		 ComicDTO comitDTO = convertirComicToComicDTO(comic);
		 
		return comitDTO;
		
	}
	 /**
	  * 
	  * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	  */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics(){
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		//TODO hacer que sea nula 
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic c").getResultList();
		
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		
		return resultadosComicDTO;
	}

	/** 
	 * metodo encargado de buscar la entidada y asignarle nuevos o modificar parametros
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long, java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	// TODO Cual es el resultado de llamar a modificar
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		
		Comic comicModificar ;
		
		if (comicNuevo == null) {
			comicModificar = em.find(Comic.class, id);
			
		} else {
			comicModificar = convertirComicDTOtoComic(comicNuevo);
		} // TODO validar si el metodo a Comic llego con datos
		comicModificar.setNombre(nombre);
		em.merge(comicModificar);
	}

	/** 
	 * Este método se encarga de eliminar una entidad de la base de datos.
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComic(Long idComic) {
		Comic comicEliminar;
		comicEliminar = em.find(Comic.class, idComic);
		
		if (comicEliminar!=null) {
			em.remove(comicEliminar);
		}
		
	}
	
	/**
	 * 
	 * Metodo encargado de permitir crear una nueva entidada
	 * <b>Caso de Uso</b>
	 * @author Yesid Rangel
	 * @param comicDTO
	 * @return
	 */
	
	private Comic convertirComicDTOtoComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
        if(comicDTO.getId()!= null) {
            comic.setId(Long.parseLong(comicDTO.getId()));
        }
        comic.setNombre(comicDTO.getNombre());
        comic.setEditorial(comicDTO.getEditorial());
        comic.setTematicaEnum(comicDTO.getTematicaEnum());
        comic.setColeccion(comicDTO.getColeccion());
        comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
        comic.setPrecio(comicDTO.getPrecio());
        comic.setAutores(comicDTO.getAutores());
        comic.setColor(comicDTO.getColor());
        comic.setFechaVenta(comicDTO.getFechaVenta());
        comic.setEstadoEnum(comicDTO.getEstadoEnun());
        comic.setCantidad(comicDTO.getCantidad());
        return comic;
		
	}
	
	private ComicDTO convertirComicToComicDTO(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        if(comic.getId()!=null) {
         comicDTO.setId(comic.getId().toString());
        }
        comicDTO.setNombre(comic.getNombre());
        comicDTO.setEditorial(comic.getEditorial());
        comicDTO.setTematicaEnum(comic.getTematicaEnum());
        comicDTO.setColeccion(comic.getColeccion());
        comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
        comicDTO.setPrecio(comic.getPrecio());
        comicDTO.setAutores(comic.getAutores());
        comicDTO.setColor(comic.getColor());
        comicDTO.setFechaVenta(comic.getFechaVenta());
        comicDTO.setEstadoEnun(comic.getEstadoEnum());
        comicDTO.setCantidad(comic.getCantidad());
        return comicDTO;
    }
	
}
