/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mario
 *
 */
public class Tablero {
	public final int FILAS = 22;
	public final int COLUMNAS = 40;
	
	private Casillero[][] casilleros;
	private static Tablero tablero;
	
	
	private Tablero() {
		casilleros = new Casillero[FILAS][COLUMNAS];
		for (int n = 0; n < FILAS; n++) {
			for (int m = 0; m < COLUMNAS; m++) {
				casilleros[n][m] = new Casillero();
			}
		}
	}
	
	public static Tablero getInstance() {
		if (tablero == null) {
			tablero = new Tablero();
		}
		return tablero;
	}

	public Personaje getPersonaje(Posicion posicion){
		return casilleros[posicion.getFila()][ posicion.getColumna()].getPersonaje();	
	}

	public Personaje getPersonaje(int fila, int columna){
		return casilleros[fila][columna].getPersonaje();	
	}
	
	public void setPersonaje(Personaje personaje) {
		//System.out.println("Agregando personaje: " + personaje + " en posicion " + personaje.getPosicion());
		// agregar el personaje al casillero correspondiente
		casilleros[personaje.getPosicion().getFila()][personaje.getPosicion().getColumna()].setPersonaje(personaje);
		//System.out.println(casilleros[personaje.getPosicion().getFila()][personaje.getPosicion().getColumna()].getPersonaje());
		
	}
	
}
