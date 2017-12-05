package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.*;

/**
 * Clase que representa el tablero del juego, donde en casa casillero hay un personaje
 * @author Mario Jáuregui Lorda
 *
 */
public class Tablero {
	private Casillero casilleros[][];
	private final int COLUMNAS = 40;
	private final int FILAS = 22;
	
	public Tablero() {
		casilleros = new Casillero[FILAS][COLUMNAS];
		inicializar(FILAS, COLUMNAS);
	}

	private void inicializar(int filas, int columnas) {
		for (int fila = 0; fila < filas; fila++) {
			for (int columna = 0; columna < columnas; columna++) {
				casilleros[fila][columna] = new Casillero();
			}
		}

	}
	
	public Personaje getPersonaje(Posicion posicion) {
		return this.casilleros[posicion.getFila()][posicion.getColumna()].getPersonaje();
	}
	
	public Personaje getPersonaje(int fila, int columna) {
		return this.casilleros[fila][columna].getPersonaje();
	}
	
	
	public boolean setPersonaje(Personaje personaje) {
		int fila = personaje.getPosicion().getFila();
		int columna = personaje.getPosicion().getColumna();
		if ((fila >= 0) && (fila < casilleros.length)) {
			if ((columna >= 0) && (columna < casilleros[0].length)) {
				casilleros[fila][columna].setPersonaje(personaje);
				return true;
			} else {
				return false;
			}
		} else { 
			return false;
		}
	}
	
}
