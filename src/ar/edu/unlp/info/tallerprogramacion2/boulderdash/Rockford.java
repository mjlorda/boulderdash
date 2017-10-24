/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

/**
 * @author mario
 *
 */
public class Rockford extends PersonajeOrientable {
	
	private static Rockford rockford;
	
	private Rockford(Posicion posicion) {
		super(posicion);
	}
	
	public static Rockford getInstance() {
		if (rockford == null) {
			rockford = new Rockford(new Posicion(2, 2));			
		}
		return rockford;
	}
	
	public static Rockford getInstance(Posicion posicion) {
		if (rockford == null) {
			rockford = new Rockford(posicion);			
		} else {
			rockford.setPosicion(posicion);
		}
		return rockford;
	}
	
	public void mover(Orientacion orientacion) {
		girar(orientacion);
		avanzar();
	}
	
	/**
	 * 
	 */
	public void avanzar() {
		
		//Posicion a la que Rockford intenta moverse
		Posicion posicionDestino = new Posicion(getPosicion().getFila(), getPosicion().getColumna());	
		
		Orientacion orientacionActual = getOrientacion();
		
		switch (orientacionActual) {
		case ARRIBA:
			posicionDestino.sumarFila(-1);
			break;
		case ABAJO:
			posicionDestino.sumarFila(1);
			break;
		case DERECHA:
			posicionDestino.sumarColumna(1);
			break;
		case IZQUIERDA:
			posicionDestino.sumarColumna(-1);
			break;
		}
		
		Personaje personajeDestino = Tablero.getInstance().getPersonaje(posicionDestino);
		
		if (personajeDestino instanceof LugarVacio) {
			setPosicion(posicionDestino);
		} else if (personajeDestino instanceof Diamante) {
			//si el lugar de destino hay un diamante, avanzar y sumar un diamante	
			recojerDiamante((Diamante)personajeDestino);
			BoulderDash.getInstance().sumarDiamante();
		} else if (personajeDestino instanceof Basura) {
			//si el lugar de destino hay basura limpiarla
			limpiarBasura((Basura)personajeDestino);
			
			setPosicion(posicionDestino);
		} else if ((personajeDestino instanceof Roca) && ((orientacionActual == Orientacion.IZQUIERDA) || (orientacionActual == Orientacion.DERECHA))){
			Roca roca = (Roca)personajeDestino;
			//si se intenta avanzar al casillero donde hay una Roca en estado ESTACIONARIO, empujarla, 
			// si roca.empujar() devuelve true significa que la roca se movio, entonces muevo a Rockford tambien
			if (roca.getEstadoEstacionario() == EstadoEstacionario.ESTACIONARIO) {
				if (roca.empujar(orientacionActual)) {
					avanzar();
				}
			}
		}		
	}
	
	private void limpiarBasura(Basura basura) {
		mensaje(this + " limpió la " + basura);
		setPosicion(basura.getPosicion());
		
	}
	private void recojerDiamante(Diamante diamante) {
		mensaje(this + " recogió el " + diamante);
		setPosicion(diamante.getPosicion());
	}
	
	private void girar(Orientacion orientacion) {
		this.orientacion = orientacion;
	}

	public void explotar() {
		//ToDo hacer explosiones
		Posicion posicion = getPosicion();
		getTablero().setPersonaje(new LugarVacio(posicion));
		mensaje(this + " explotó");
		BoulderDash.getInstance().getNivel().setFin(true);
		
	}
	@Override
	public void ejecutarTurno() {
		// si se presiono una flecha, realizar el movimiento
		
	}
	
}
