/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

/**
 * @author mario
 *
 */
public class Roca extends PersonajeEstacionario {
	
	public Roca(Posicion posicion) {
		super(posicion);
		
	}
	
	/**
	 * Método para empujar una Roca.
	 * @param orientacion Dirección en la que se empuja la Roca.
	 * @return Devuelve true si se logró mover la roca, false en caso contrario.
	 */
	public boolean empujar(Orientacion orientacion) {
		mensaje("Rockford intentó empujar la " + this + " hacia la " + orientacion);
		int filaActual = getPosicion().getFila();
		int columnaActual = getPosicion().getColumna();
		if (orientacion == Orientacion.DERECHA) {
			Personaje personajeDerecha = getTablero().getPersonaje(filaActual, columnaActual + 1);
			if (personajeDerecha instanceof LugarVacio) {
				setPosicion(personajeDerecha.getPosicion());
				return true;
			} else {
				return false;
			}
		} else if (orientacion == Orientacion.IZQUIERDA) {
			Personaje personajeIzquierda = getTablero().getPersonaje(filaActual, columnaActual = 1);
			if (personajeIzquierda instanceof LugarVacio) {
				setPosicion(personajeIzquierda.getPosicion());
				return true;
			} else {
				return false;
			}
		// si por error se intenta empujar hacia arriba o hacia abajo retornar false
		} else {
			return false;
		}
	}
}
