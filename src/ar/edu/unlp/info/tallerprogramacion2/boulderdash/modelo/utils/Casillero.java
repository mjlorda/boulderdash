/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.controlador.TableroControlador;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;;

/**
 * Clase que representa un casillero del tablero de juego.
 * @author Mario Jáuregui Lorda
 *
 */
public class Casillero {
	private Personaje personaje;

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
		//GuiJuego.getInstance().setPersonaje(personaje);
		TableroControlador.getInstance().dibujarPersonaje(personaje);
	}
	

}
