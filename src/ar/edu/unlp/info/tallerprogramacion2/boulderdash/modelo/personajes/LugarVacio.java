package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.Ameba;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.PersonajeEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Enemigo;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa un lugar vacío.
 * @author Mario Jáuregui Lorda
 *
 */
public class LugarVacio extends Personaje {
	
	public LugarVacio(Posicion posicion) {
		super(posicion);
	}

	@Override
	public boolean ocuparLugar(PersonajeEstacionario personaje) {
		return true;
	}
	
	@Override
	public boolean ocuparLugar(Rockford rockford) {
		return true;
	}
	
	@Override
	public boolean ocuparLugar(Enemigo personaje) {
		return true;
	}
	
	@Override
	public boolean ocuparLugar(Ameba personaje) {
		return true;
	}
	
	
	/**
	 * Realiza la acción de explotar el personaje.
	 */
	@Override
	public void explotar() {
		System.out.println(this + " explotó");
	}
	

}
