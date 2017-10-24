/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

/**
 * @author mario
 *
 */
public class Mariposa extends PersonajeOrientable {
	public Mariposa(Posicion posicion) {
		super(posicion);
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
			setOrientacion(Orientacion.IZQUIERDA);
			break;
		case ABAJO:
			setOrientacion(Orientacion.DERECHA);
			break;
		case DERECHA:
			setOrientacion(Orientacion.ARRIBA);
			break;
		case IZQUIERDA:
			setOrientacion(Orientacion.ABAJO);
			break;
		}

	}

	@Override
	public void ejecutarTurno() {
		avanzar();
		
	}
}
