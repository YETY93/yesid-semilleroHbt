package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;
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
	@Test
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
	 * Pruebas  para validar cadenas (test)
	 * 
	 */
	@Test
	public void pruebaCadenas() {
		
		String resultado = invertirCadena("Esto es una cadena");
		String cadenaInvertida = ("anedac anu se otsE");
		
		Assert.assertEquals(cadenaInvertida, resultado);
		
		String cadenaInvertidaDos = ("cadena anu se otsE");
		Assert.assertNotEquals(cadenaInvertida, resultado);
	}
	
	
	public void pruebaCadenaVacia() {
		String cadenaEsperada = "";
		String resultadoReal = invertirCadena(" ");
		Assert.assertNotEquals(resultadoReal, cadenaEsperada);
	}
	

}
