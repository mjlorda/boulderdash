/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

/**
 * @author mario
 *
 */
public class Luciernaga extends PersonajeOrientable {

	public Luciernaga(Posicion posicion) {
		super(posicion);
		// TODO Auto-generated constructor stub
	}
	
	public void avanzar() {
		Posicion destino = new Posicion(getPosicion().getFila(), getPosicion().getColumna());		
		switch (getOrientacion()) {
			case ARRIBA:
			destino.sumarFila(-1);
			break;
		case ABAJO:
			destino.sumarFila(1);
			break;
		case DERECHA:
			destino.sumarColumna(1);
			break;
		case IZQUIERDA:
			destino.sumarColumna(-1);
			break;
		}
		Personaje personajeEnDestino = getTablero().getPersonaje(destino);
		if (personajeEnDestino instanceof LugarVacio){
			setPosicion(destino);
		} else {
			girar();
		}
	}
	private void girar() {
		
		switch (getOrientacion()) {
		case ARRIBA:
			setOrientacion(Orientacion.DERECHA);
			break;
		case ABAJO:
			setOrientacion(Orientacion.IZQUIERDA);
			break;
		case DERECHA:
			setOrientacion(Orientacion.ABAJO);
			break;
		case IZQUIERDA:
			setOrientacion(Orientacion.ARRIBA);
			break;
		}
	}

	@Override
	public void ejecutarTurno() {
		avanzar();
		
	}
	
	@Override
	public void setPosicion(Posicion posicion) {
		super.setPosicion(posicion);
		int filaActual = posicion.getFila();
		int columnaActual = posicion.getColumna();
		/* Verifico los cuatro casilleros contiguos para ver si está Rockford */
		Personaje personaje = getTablero().getPersonaje(filaActual + 1, columnaActual);
		if (personaje instanceof Rockford) {
			explotar();
		}
		personaje = getTablero().getPersonaje(filaActual - 1, columnaActual);
		if (personaje instanceof Rockford) {
			explotar();
		}
		personaje = getTablero().getPersonaje(filaActual, columnaActual + 1);
		if (personaje instanceof Rockford) {
			explotar();
		}
		personaje = getTablero().getPersonaje(filaActual, columnaActual - 1);
		if (personaje instanceof Rockford) {
			explotar();
		}
			
	}
	
	
}
