/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.EstadoEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa al personaje Roca.
 * @author mario
 *
 */
public class Roca extends PersonajeEstacionario {
	
	private static Image imagen;
	public Roca(Posicion posicion) {
		super(posicion);
	}
	
	
	@Override
	public boolean ocuparLugar(Rockford rockford) {
		Orientacion orientacionRockford = rockford.getOrientacion();
		Posicion posicionDestino = new Posicion(getPosicion().getFila(), getPosicion().getColumna());
		posicionDestino.mover(rockford.getOrientacion());
		
		if (getEstadoEstacionario() == EstadoEstacionario.ESTACIONARIO) {
			//System.out.println("Rockford intentó empujar la " + this + " hacia la " + orientacionRockford);
			if (((orientacionRockford == Orientacion.IZQUIERDA) || (orientacionRockford == Orientacion.DERECHA)) && 
					Juego.getInstance().getPersonaje(posicionDestino).ocuparLugar(this)) {
				Juego.getInstance().moverPersonaje(this, orientacionRockford);
				//mover(orientacionRockford);
				return true;
				
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
	
	/**
	 * Método para empujar una Roca.
	 * @param orientacion Dirección en la que se empuja la Roca.
	 * @return Devuelve true si se logró mover la roca, false en caso contrario.
	 */
/*	public boolean empujar(Orientacion orientacion) {
		if (getEstadoEstacionario() == EstadoEstacionario.ESTACIONARIO) {
			System.out.println("Rockford intentó empujar la " + this + " hacia la " + orientacion);
			int filaActual = getPosicion().getFila();
			int columnaActual = getPosicion().getColumna();
			if (orientacion == Orientacion.DERECHA) {
				Personaje personajeDerecha = Juego.getInstance().getPersonaje(filaActual, columnaActual + 1);
				if (personajeDerecha instanceof LugarVacio) {
					setPosicion(personajeDerecha.getPosicion());
					return true;
				} else {
					return false;
				}
			} else if (orientacion == Orientacion.IZQUIERDA) {
				Personaje personajeIzquierda = Juego.getInstance().getPersonaje(filaActual, columnaActual = 1);
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
		} else {
			// Si la roca esta en estado CAYERNDO retornar false
			return false;
		}

	}*/
}
