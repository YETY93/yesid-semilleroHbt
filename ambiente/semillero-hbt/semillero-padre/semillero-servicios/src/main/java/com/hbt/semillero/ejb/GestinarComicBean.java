/**
 * GestinarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
public class GestinarComicBean {

	@PersistenceContext
	private EntityManager em;

	// TODO Agregar interface

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());

		/**
		 * TODO llenar datos
		 */

		em.persist(comic);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicDTO ) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		em.merge(comic);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class, id);
		 ComicDTO comitDTO = new ComicDTO(comic.getId(),comic.getNombre() );
		return comitDTO;
		
	}
	
	public List<ComicDTO> consultarComics(){
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}
	
}
