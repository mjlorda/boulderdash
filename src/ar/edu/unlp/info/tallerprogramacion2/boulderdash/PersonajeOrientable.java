/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

/**
 * @author mario
 *
 */
public abstract class PersonajeOrientable extends Personaje implements PersonajeAnimado {
	protected Orientacion orientacion;

	public PersonajeOrientable(Posicion posicion) {
		super(posicion);
		this.orientacion = Orientacion.DERECHA;
	}
	
	public PersonajeOrientable(int fila, int columna) {
		super(fila, columna);
		this.orientacion = Orientacion.DERECHA;
	}

	public Orientacion getOrientacion() {
		return orientacion;
	}
	
	public void setOrientacion(Orientacion orientacion) {
		mensaje(this + " cambio la orientacion de " + this.orientacion + " a " + orientacion);
		this.orientacion = orientacion;
	
	}
	
	
}
