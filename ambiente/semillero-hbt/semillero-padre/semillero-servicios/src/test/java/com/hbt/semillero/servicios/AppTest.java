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
 * Test unitario primiera clase
 */

public class AppTest{
	public void  shoulAnswerWitcTrue() {
		
	}

	
	/**
	 * Metodo para validar la suma de dos numero 
	 * 
	 */
	@Test(enabled = false)
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long operacionResultado = sumando1 + sumando2;
		Assert.assertEquals(operacionResultado, resultadoEsperado);	
		
		Assert.assertNotEquals(operacionResultado, resultadoEsperado);
	}
	
	/**
	 * 
	 * Metodo encargado  invertir una cadena 
	 * 
	 */
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}
	
	/**
	 * Pruebas  para validar cadenas (test) del taller numero dos
	 * 
	 */
	@Test(enabled = false)
	public void pruebaCadenas() {
		
		String resultado = invertirCadena("Esto es una cadena");
		String cadenaInvertida = ("anedac anu se otsE");
		
		Assert.assertEquals(cadenaInvertida, resultado);
		
		String cadenaInvertidaDos = ("cadena anu se otsE");
		Assert.assertNotEquals(cadenaInvertida, resultado);
	}
	
	/**
	 * Pruebas  para validar cadenas (test) del taller numero dos
	 * 
	 */
	@Test(enabled = false)
	public void pruebaCadenaVacia() {
		String cadenaEsperada = "";
		String resultadoReal = invertirCadena(" ");
		Assert.assertNotEquals(resultadoReal, cadenaEsperada);
	}
	
	

	/**
	 * test para probar los enum del atributo  EstadoEnum 
	 *  ejercicio numero 2
	 */
	@Test(enabled = false)
	public void testSesionDos() {
		
		// Instanciar enumerado
		EstadoEnum estado = EstadoEnum.ACTIVO;
		
		
		Assert.assertTrue(estado.equals(EstadoEnum.ACTIVO));
		Assert.assertFalse(estado.equals(EstadoEnum.INACTIVO));


		// Posicion del enum en la declaracion
		Assert.assertEquals(EstadoEnum.INACTIVO.ordinal(), 1);

		// Devolver un array con todos los enums de EstadoEnum
		EstadoEnum[] arrayEsperado = { EstadoEnum.ACTIVO, EstadoEnum.INACTIVO };
		
		// Tets del array de EstadoEnum
		Assert.assertEquals(EstadoEnum.values(), arrayEsperado);

	}

	
	
	/**
	 * Pruebas  para validar la creacion de comicDTO (test) de la clase tres
	 * 
	 */
	
	@Test
	public void crearComicDTOtest () {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() != 0);
		Assert.assertTrue(gestionarComicPOJO.getListaComics().isEmpty());

	}

	/**
	 * Pruebas  para validar la creacion de comicDTO (test) de la clase tress
	 * 
	 */
	@Test
	public void crearComicDTOtestDOS () {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("101", "Captain America Corps 1-5 USA", "Panini Comics", TematicaEnum.AVENTURAS, "BIBLIOTECA MARVEL", 128,new BigDecimal(5000), "Phillippe Briones, Roger Ster", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);
	
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().isEmpty());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);
		
		comicDTO = new ComicDTO();
		comicDTO.setId("100");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("PLaneta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnun(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);
		
	}
	
	
	
	//TODO
	/*
	 * Pendiente hacer un metodo que use el método ToString de la entidad Comic 
	 */
	

}
