package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

public abstract class PersonajeAnimado extends Personaje {

	public PersonajeAnimado(Posicion posicion) {
		super(posicion);
		Juego.getInstance().agregarAListaAnimados(this);
		
	}
	
	public abstract void ejecutarTurno(int turno);
	
	public void explotar() {
		super.explotar();
		Juego.getInstance().removerDeListaAnimados(this);
	}
	

}
