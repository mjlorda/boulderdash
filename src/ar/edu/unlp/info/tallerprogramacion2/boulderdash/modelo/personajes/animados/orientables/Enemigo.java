package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.PersonajeEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.EstadoEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * @author Mario Jáuregui Lorda
 *
 */
public abstract class Enemigo extends PersonajeOrientable {

	public Enemigo(Posicion posicion) {
		super(posicion);
	}
	
	/**
	 * Intenta mover el Enemigo una posición hacia la orientación actual. Si el casillero destino no está vacío, 
	 * gira y espera el próximo turno para intentar avanzar.
	 * 
	 */
	@Override
	public void avanzar() {
		
		Posicion posicionDestino = getPosicion().copiar().mover(getOrientacion());
		Personaje personajeEnDestino = Juego.getInstance().getPersonaje(posicionDestino);
		
		if (personajeEnDestino.ocuparLugar(this)){
			super.avanzar();
		} else {
			girar();
		}
	}
	
	
	protected abstract void girar();
	/*
	@Override
	public boolean ocuparLugar(PersonajeEstacionario personajeEstacionario) {
		if (personajeEstacionario.getEstadoEstacionario() == EstadoEstacionario.CAYENDO) {
			explotar();
			return true;
		}
		return false;
	}
	*/
	
	/**
	 * Verifica si está Rockford en alguno de los cuatro casilleros contiguos  
	 * en cuyo caso lo hace explotar.
	 */
	protected void verificarRockford() {
		Posicion posicionAuxiliar;
		Personaje personajeDestino;
		for (Orientacion orientacion: Orientacion.values()) {
			posicionAuxiliar = getPosicion().copiar().mover(orientacion);
			personajeDestino = Juego.getInstance().getPersonaje(posicionAuxiliar);
			personajeDestino.ocuparLugar(this);
		}
		
		
	}
	
	/** 
	 * Ejecuta las acciones que dere realizar la Luciérnaga en cada turno.
	 */
	@Override
	public void ejecutarTurno(int turno) {
		avanzar();
		verificarRockford();
	}


}
