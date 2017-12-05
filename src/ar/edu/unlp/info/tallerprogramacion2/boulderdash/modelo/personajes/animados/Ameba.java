package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados;

import java.util.Random;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa al personaje Ameba
 * @author Mario Jáuregui Lorda
 *
 */
public class Ameba extends PersonajeAnimado {

	private Random random;
	
	private Random getRandom() {
		return random;
	}

	private void setRandom(Random random) {
		this.random = random;
	}

	public Ameba(Posicion posicion) {
		super(posicion);
		random  = new Random();
	}
	
	public void crecer(Posicion posicion) {
		Juego.getInstance().setPersonaje(new Ameba(posicion));
		//System.out.println("La ameba se expandió a la posicion " + posicion);
	}

	/** 
	 * 
	 * Método que se ejecuta una vez cada turno y realiza las acciones que debe realizar el personaje. 
	 * En este caso obtiene un número aleatorio y crece en dirección aleatoria o no crece.
	 */
	@Override
	public void ejecutarTurno(int turno) {
		getRandom().setSeed(System.currentTimeMillis());
		int intAleatorio = getRandom().nextInt(50);
		
		Posicion posicionDestino = getPosicion().copiar();
		
		switch (intAleatorio){
		/* Si el numero aleatorio está entre 1 y cuatro, elige una direccion para crecer */
		case 1:
			posicionDestino.mover(Orientacion.ARRIBA);
			break;
		case 2:
			posicionDestino.mover(Orientacion.DERECHA);
			break;
		case 3:
			posicionDestino.mover(Orientacion.ABAJO);
			break;
		case 4:
			posicionDestino.mover(Orientacion.IZQUIERDA);
			break;
		default:
			/* si el numero aleatorio no esta entre 1 y 4 salir sin intentar moverse */
			return;
		}

		Personaje personajeDestino = Juego.getInstance().getPersonaje(posicionDestino);
		
		if ((personajeDestino.ocuparLugar(this))) {
			crecer(posicionDestino);
		}
	}
	
}


