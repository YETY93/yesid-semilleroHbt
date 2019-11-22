/**
 * EjerciciosTest.java
 */
package com.hbt.semillero.servicios;

import java.util.IntSummaryStatistics;

import org.testng.annotations.Test;

import com.hbt.semillero.rest.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase que determina los test de  clase ejerciciosPOJO
 * <b>Caso de Uso:<b> 
 * @author Nuevo
 * @version 
 */
public class EjerciciosTest {
	
	
	@Test
	public void testEjejrcico5() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		
		int numero;
		
		numero = 50;
		ejerciciosPOJO.agregarElemento(numero);
		numero = 1;
		ejerciciosPOJO.agregarElemento(numero);
		numero = 249;
		ejerciciosPOJO.agregarElemento(numero);
		numero = -2;
		ejerciciosPOJO.agregarElemento(numero);
		
		IntSummaryStatistics valores  = ejerciciosPOJO.getlistaNUmeros().stream().mapToInt((x) -> x).summaryStatistics();		
		
		valores.getMin();
		valores.getMax();
		valores.getCount();
		
	}
	
	
	
	

}
