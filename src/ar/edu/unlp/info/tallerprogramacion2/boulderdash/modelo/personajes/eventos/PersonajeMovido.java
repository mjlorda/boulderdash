package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.eventos;

import java.util.EventObject;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;

public class PersonajeMovido extends EventObject{

	public PersonajeMovido(Personaje personaje) {
		super(personaje);
		
	}

}
