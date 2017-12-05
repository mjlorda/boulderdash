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
 * Clase que representa una mariposa.
 * @author mario
 *
 */
public class Mariposa extends Enemigo {
	
	public Mariposa(Posicion posicion) {
		super(posicion);
	}
	
	
	/**
	 * Gira la orientación de la Mariposa en sentido contrario a las agujas del reloj.
	 */
	@Override
	protected void girar() {
		
		switch (getOrientacion()) {
		case ARRIBA:
			setOrientacion(Orientacion.IZQUIERDA);
			break;
		case ABAJO:
			setOrientacion(Orientacion.DERECHA);
			break;
		case DERECHA:
			setOrientacion(Orientacion.ARRIBA);
			break;
		case IZQUIERDA:
			setOrientacion(Orientacion.ABAJO);
			break;
		}

	}

}
