/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.PersonajeAnimado;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.PersonajeEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.EstadoEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase abstracta que representa un personaje que tiene una orientación.
 * @author mario
 *
 */
public abstract class PersonajeOrientable extends PersonajeAnimado {
	protected Orientacion orientacion;

	public PersonajeOrientable(Posicion posicion) {
		super(posicion);
		this.orientacion = Orientacion.DERECHA;
	}

	public Orientacion getOrientacion() {
		return orientacion;
	}
	
	/**
	 * @param orientacion
	 */
	public void setOrientacion(Orientacion orientacion) {
		//System.out.println(this + " cambio la orientacion de " + this.orientacion + " a " + orientacion);
		this.orientacion = orientacion;
	
	}
	
	@Override
	public boolean ocuparLugar(PersonajeEstacionario personajeEstacionario) {
		if (personajeEstacionario.getEstadoEstacionario() == EstadoEstacionario.CAYENDO) {
			Posicion posicionAuxiliar = getPosicion().copiar();
			this.explotar();
			posicionAuxiliar.mover(Orientacion.ARRIBA);
			Juego.getInstance().getPersonaje(posicionAuxiliar).explotar();
			posicionAuxiliar.mover(Orientacion.IZQUIERDA);
			Juego.getInstance().getPersonaje(posicionAuxiliar).explotar();
			posicionAuxiliar.mover(Orientacion.ABAJO);
			Juego.getInstance().getPersonaje(posicionAuxiliar).explotar();
			posicionAuxiliar.mover(Orientacion.ABAJO);
			Juego.getInstance().getPersonaje(posicionAuxiliar).explotar();
			posicionAuxiliar.mover(Orientacion.DERECHA);
			Juego.getInstance().getPersonaje(posicionAuxiliar).explotar();
			posicionAuxiliar.mover(Orientacion.DERECHA);
			Juego.getInstance().getPersonaje(posicionAuxiliar).explotar();
			posicionAuxiliar.mover(Orientacion.ARRIBA);
			Juego.getInstance().getPersonaje(posicionAuxiliar).explotar();
			posicionAuxiliar.mover(Orientacion.ARRIBA);
			Juego.getInstance().getPersonaje(posicionAuxiliar).explotar();
		}
		return false;
	}
	
	/**
	 * Mueve el personaje una posición hacia la dirección en la que se encuentra orientado.
	 */
	public void avanzar() {
		
		Juego.getInstance().moverPersonaje(this, orientacion);
			
		//getPosicion().mover(orientacion);
	}

	
	
	
}
