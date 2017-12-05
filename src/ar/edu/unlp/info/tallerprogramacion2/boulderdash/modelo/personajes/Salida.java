/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa la salida de cada nivel.
 * @author mario
 *
 */
public class Salida extends Personaje {
	
	private boolean activada;
	
	public Salida(Posicion posicion) {
		super(posicion);
		this.activada = false;
	}

	public boolean isActivada() {
		return activada;
	}

	public void setActivada(boolean activada) {
		this.activada = activada;
	}

	
}
