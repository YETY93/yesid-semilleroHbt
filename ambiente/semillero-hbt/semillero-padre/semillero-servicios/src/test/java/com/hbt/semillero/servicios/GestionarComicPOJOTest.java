/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojos.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que determina los test para veficar los POJOs
 * <b>Caso de Uso:<b> 
 * @author Yesid Rangel
 * @version 
 */
public class GestionarComicPOJOTest {
	
	
	
	/**
	 * 
	 * Metodo encargado de  hacer pruebas a gestionarComic
	 * <b>Caso de Uso</b>
	 * @author Yesid Rangel
	 * 
	 * @param gestionarComic
	 */
	
	@Test
	private void crearComics(GestionarComicPOJO gestionarComic) {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("1");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(144);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnun(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);

		gestionarComic.agregarComicDTOLista(comicDTO);

		// Verificar que la lista tiene 1 elemneto
		assert gestionarComic.getListaComics().size() == 1 : String.format("La lista tiene (%d) elementos",
				gestionarComic.getListaComics().size());

		comicDTO = new ComicDTO();
		comicDTO.setId("2");
		comicDTO.setNombre("Captain America Corps 1-5 USA");
		comicDTO.setEditorial("Panini Comics ");
		comicDTO.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO.setColeccion("BIBLIOTECA MARVEL ");
		comicDTO.setNumeroPaginas(128);
		comicDTO.setPrecio(new BigDecimal(5000));
		comicDTO.setAutores("Phillippe Briones, Roger Stern ");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnun(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(5L);

		gestionarComic.agregarComicDTOLista(comicDTO);

		// Verificar que la lista tiene 2 elemnetos
		assert gestionarComic.getListaComics().size() == 2 : String.format("La lista tiene (%d) elementos",
				gestionarComic.getListaComics().size());

		comicDTO = new ComicDTO();
		comicDTO.setId("3");
		comicDTO.setNombre("The Spectacular Spider-Man v2 USA");
		comicDTO.setEditorial("Panini Comics ");
		comicDTO.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO.setColeccion("MARVEL COMICS");
		comicDTO.setNumeroPaginas(208);
		comicDTO.setPrecio(new BigDecimal(6225));
		comicDTO.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnun(EstadoEnum.INACTIVO);
		comicDTO.setCantidad(0L);

		gestionarComic.agregarComicDTOLista(comicDTO);

		// Verificar que la lista tiene 3 elemnetos
		assert gestionarComic.getListaComics().size() == 3 : String.format("La lista tiene (%d) elementos",
				gestionarComic.getListaComics().size());
		
		// Verificar que el comic tiene el id 2
		gestionarComic.modificarComicDTO("2", "ironman");
		Assert.assertEquals(gestionarComic.getListaComics().get(1).getNombre(), "ironman");
		
	}

	

}
