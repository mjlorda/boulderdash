/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

/**
 * @author mario
 *
 */
public abstract class PersonajeEstacionario extends Personaje implements PersonajeAnimado {
	private EstadoEstacionario estadoEstacionario;
	
	public PersonajeEstacionario(Posicion posicion) {
		super(posicion);
		this.estadoEstacionario = EstadoEstacionario.ESTACIONARIO;
	}
	
	public PersonajeEstacionario(int fila, int columna) {
		super(fila, columna);
		this.estadoEstacionario = EstadoEstacionario.ESTACIONARIO;
	}

	public EstadoEstacionario getEstadoEstacionario() {
		return estadoEstacionario;
	}

	public void setEstadoEstacionario(EstadoEstacionario estadoEstacionario) {
		mensaje(this + " cambió de estado " + this.estadoEstacionario + " a estado " + estadoEstacionario);
		this.estadoEstacionario = estadoEstacionario;
	}
	
	public void deslizar(Orientacion orientacion) {
		//ToDo implementar deslizar
	}
	
	public void caer() {
		//ToDo implementar caer
		
	}
	
	public void ejecutarTurno() {
		int filaActual, columnaActual;
		filaActual = getPosicion().getFila();
		columnaActual = getPosicion().getColumna();
		Personaje personajeAbajo = getTablero().getPersonaje(filaActual + 1, columnaActual);
		
		if (getEstadoEstacionario() == EstadoEstacionario.ESTACIONARIO) {
			if (personajeAbajo instanceof LugarVacio) {
				this.setEstadoEstacionario(EstadoEstacionario.CAYENDO);	
			} else if (personajeAbajo instanceof PersonajeEstacionario){
				Personaje personajeIzquierda = getTablero().getPersonaje(filaActual, columnaActual - 1);
				Personaje personajeAbajoIzquierda = getTablero().getPersonaje(new Posicion(filaActual
						+ 1, columnaActual - 1));
                				
				if ((personajeIzquierda instanceof LugarVacio) && (personajeAbajoIzquierda instanceof LugarVacio)) {
					this.setPosicion(filaActual, columnaActual - 1);
					this.setEstadoEstacionario(EstadoEstacionario.CAYENDO);
					
				} else {
					Personaje personajeDerecha = getTablero().getPersonaje(filaActual, columnaActual + 1);
					Personaje personajeAbajoDerecha = getTablero().getPersonaje(filaActual + 1, columnaActual + 1);
					if ((personajeDerecha instanceof LugarVacio) && (personajeAbajoDerecha instanceof LugarVacio)) {
						this.setPosicion(new Posicion(filaActual, columnaActual + 1));
						this.setEstadoEstacionario(EstadoEstacionario.CAYENDO);
					}
				}
			}
		} else {
			//Si esta CAYENDO
			if (personajeAbajo instanceof LugarVacio) {
				this.setPosicion(filaActual + 1, columnaActual);
			//si abajo hay un PersonajeOrientable (Rockford, Luciernaga o Mariposa) hacerlo explotar	
			} else if (personajeAbajo instanceof PersonajeOrientable) {
				personajeAbajo.explotar();
			} else {
				this.setEstadoEstacionario(EstadoEstacionario.ESTACIONARIO);
			}
		}
	}
	
}
