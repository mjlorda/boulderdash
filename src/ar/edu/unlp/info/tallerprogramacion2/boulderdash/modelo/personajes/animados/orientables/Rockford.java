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
 * Clase que representa al personaje Rockford (jugador). 
 * @author mario
 *
 */
public class Rockford extends PersonajeOrientable {
	
	private static Rockford rockford;
	private boolean muerto;
	private boolean movimientoPendiente;
	private boolean movimientoCompletado;
	
	//private long turnoUltMovimiento = 0;
	private boolean teclaSoltada;
	
	private Rockford(Posicion posicion) {
		super(posicion);
	}
	
	public static Rockford getInstance() {
		if (rockford == null) {
			rockford = new Rockford(new Posicion(0, 0));			
		}
		return rockford;
	}
	
	public static Rockford getInstance(Posicion posicion) {
		if (rockford == null) {
			rockford = new Rockford(posicion);			
		} else {
			rockford.setPosicion(posicion);
			Juego.getInstance().agregarAListaAnimados(rockford);
		}
		return rockford;
	}
	
	public boolean isMuerto() {
		return muerto;
	}

	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
		if (muerto == true) {
			System.out.println("El juego terminó");
		}
	}


	public boolean ocuparLugar(Enemigo enemigo) {
		explotar();
		return false;
	}
	
	public void mover(Orientacion orientacion) {
		girar(orientacion);
		avanzar();
	}
	
		
	/**
	 * 
	 */
	public void avanzar() {
		Posicion posicionDestino = getPosicion().copiar().mover(orientacion);
		Personaje personajeDestino = Juego.getInstance().getPersonaje(posicionDestino);
		if (personajeDestino.ocuparLugar(this)) {
			super.avanzar();
		}
	}

	private void girar(Orientacion orientacion) {
		this.orientacion = orientacion;
	}
	
	public void explotar() {
		super.explotar();
		//System.out.println(this + " explotó");
		setMuerto(true);
	}
	
	@Override
	public void ejecutarTurno(int turno) {
		//if ((!teclaSoltada) && (movimientoPendiente)){
		//if (this.turnoUltMovimiento < turno) {
		if (this.movimientoPendiente) {
			avanzar();
			movimientoCompletado = true;
			//this.turnoUltMovimiento = turno;
			//} else {
				//System.out.println("Salteando mov");
			//}
		//}
		//if (isMovimientoPendiente()) {
		//	avanzar();
		//	setMovimientoPendiente(false);
		}
		// si se presiono una flecha, realizar el movimiento
	}

	public void finalizarMovimiento(Orientacion orientacion) {
		if (getOrientacion() == orientacion) {
			setMovimientoPendiente(false);
		}
	}
	public void comenzarMovimiento(Orientacion orientacion) {
		setOrientacion(orientacion);
		setMovimientoPendiente(true);
		//setMovimientoCompletado(false);
		
	}
	
	public void setTeclaSoltada(boolean teclaSoltada) {
		this.teclaSoltada = teclaSoltada;
	}
	
	public boolean isMovimientoPendiente() {
		return movimientoPendiente;
	}

	public void setMovimientoPendiente(boolean movimientoPendiente) {
		this.movimientoPendiente = movimientoPendiente;
	}
	
	/**
	 * @return the movimientoCompletado
	 */
	public boolean isMovimientoCompletado() {
		return movimientoCompletado;
	}

	/**
	 * @param movimientoCompletado the movimientoCompletado to set
	 */
	public void setMovimientoCompletado(boolean movimientoCompletado) {
		this.movimientoCompletado = movimientoCompletado;
	}


	
}
