/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <b>Descripción:<b> Clase que determina pruebas de logica
 * <b>Caso de Uso:<b> 
 * @author Nuevo
 * @version 
 */
public class EjerciciosPOJO {
	
	
	private ArrayList<Integer> listaNUmeros;
	
	/**
	 * este metodo agregaa un numero a la lista
	 *
	 */
	
	public void agregarElemento(int numero) {
		
		this.listaNUmeros.add(numero);
	
	}
	
	/**
	 *
	 * Metodo encargado de ordenar la lista
	 * <b>Caso de Uso</b>
	 * @author Nuevo
	 * 
	 * @param lista
	 */
	
	public void ordenarLista(ArrayList <Integer>lista) {
		
		Collections.sort(lista);
		
	}
	
	/**
	 * metodo retornara una lista
	 */
	
	public ArrayList<Integer> getlistaNUmeros(){
		
		return listaNUmeros;
	}
	
	
	
	
	/**
	 * returnar el siguiente secuencia
	 * 
	 */
	

}
