/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.muros;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.LugarVacio;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.Diamante;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.PersonajeEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.Roca;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.EstadoMagico;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa un muro mágico, el cual convierte rocas en diamantes y viceversa durante un tiempo determinado.
 * @author mario
 *
 */
public class MuroMagico extends Muro {
	
	private final int TIEMPO_MAXIMO = 10;
	private EstadoMagico estadoMagico;
	private int tiempoRestante;
	private boolean usado;
	
	public MuroMagico(Posicion posicion) {
		super(posicion);
		this.estadoMagico = EstadoMagico.NORMAL;
		this.tiempoRestante = 0;
		this.usado = false;
	}

	public EstadoMagico getEstadoMagico() {
		return estadoMagico;
	}

	public void setEstadoMagico(EstadoMagico estadoMagico) {
		/* Si se intenta cambiar a estado MAGICO, verificar que no este usado y en ese caso, cambiarlo 
		 * a estado MAGICO, poner usado en true y establecer el tiempo restante */
		if ((estadoMagico == EstadoMagico.MAGICO)) {
			if (usado == false) {
				setTiempoRestante(TIEMPO_MAXIMO);
				setUsado(true);
				this.estadoMagico = estadoMagico;
			}
			
		} else {
			this.estadoMagico = estadoMagico;
		}		
	}

	
	public int getTiempoRestante() {
		return tiempoRestante;
	}

	public void setTiempoRestante(int tiempoRestante) {

		this.tiempoRestante = tiempoRestante;
		if (tiempoRestante == 0) {
			setEstadoMagico(EstadoMagico.NORMAL);
		}
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	
	/**
	 * Si el MuroMagico está en estado MAGICO transforma una Roca que cae sobre él en Diamante y viceversa
	 * 
	 * @param personaje PersonajeEstacionario a convertir.
	 */
	public void convertir(PersonajeEstacionario personaje) {
		if (estadoMagico == EstadoMagico.MAGICO) {
			Posicion posicionDestino = new Posicion(getPosicion().getFila(), getPosicion().getColumna() + 1);
			/* Si hay lugar abajo del muro crear el personaje converito en ese lugar */
			if (Juego.getInstance().getPersonaje(posicionDestino) instanceof LugarVacio) {
				if (personaje instanceof Roca) {
					Juego.getInstance().setPersonaje(new Diamante(posicionDestino));
				} else {
					Juego.getInstance().setPersonaje(new Roca(posicionDestino));
				}	
			}
			/* si se convirtió poner la posición original en LugarVacio */
			Juego.getInstance().setPersonaje(new LugarVacio(personaje.getPosicion()));
		} 
	}	
}
