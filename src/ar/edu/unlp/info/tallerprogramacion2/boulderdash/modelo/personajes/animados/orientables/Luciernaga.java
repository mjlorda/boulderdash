/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.LugarVacio;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa una luciernaga.
 * @author mario
 *
 */
public class Luciernaga extends Enemigo {

	public Luciernaga(Posicion posicion) {
		super(posicion);
		// TODO Auto-generated constructor stub
	}
	
		
	/**
	 * Gira la orientación de la Luciernaga en sentido de las agujas del reloj.
	 */
	@Override
	protected void girar() {
		
		switch (getOrientacion()) {
		case ARRIBA:
			setOrientacion(Orientacion.DERECHA);
			break;
		case ABAJO:
			setOrientacion(Orientacion.IZQUIERDA);
			break;
		case DERECHA:
			setOrientacion(Orientacion.ABAJO);
			break;
		case IZQUIERDA:
			setOrientacion(Orientacion.ARRIBA);
			break;
		}
	}
	
}
