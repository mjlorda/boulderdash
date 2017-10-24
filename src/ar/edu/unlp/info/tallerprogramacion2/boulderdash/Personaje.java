package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

public abstract class Personaje {
	
	private Posicion posicion;
	private Tablero tablero;

	public Tablero getTablero() {
		return Tablero.getInstance();
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public Personaje(Posicion posicion) {
		this.posicion = posicion;
		this.tablero = Tablero.getInstance();
		getTablero().setPersonaje(this);
	}

	public Personaje(int fila, int columna) {
		this.posicion = new Posicion(fila, columna);
		this.tablero = Tablero.getInstance();
		getTablero().setPersonaje(this);
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		mensaje(this + " se movio a la posicion " + posicion);
		Posicion posicionActual = this.posicion;
		this.posicion = posicion;
		tablero.setPersonaje(new LugarVacio(posicionActual));
		tablero.setPersonaje(this);
	}
	
	public void setPosicion(int fila, int columna) {
		mensaje(this + " se movio a la posicion (" + fila + ", " + columna + ")");
		Posicion posicionActual = this.posicion;
		this.posicion = new Posicion(fila, columna);
		tablero.setPersonaje(new LugarVacio(posicionActual));
		tablero.setPersonaje(this);
	}
	
	
	public void explotar() {
		mensaje(this + " explotó");
		int filaActual = getPosicion().getFila();
		int columnaActual = getPosicion().getColumna();
		Personaje personaje;
		
		for (int y = filaActual - 1; y <= filaActual + 1; y++) {
			for (int x = columnaActual - 1; x <= columnaActual + 1; x++) {
				personaje = getTablero().getPersonaje(y, x);
				/*Cualquier personaje que no sea Rockford lo transformo en LugarVacio
				 * para que no provoque explosión en cadena
				 */
				if (!(personaje instanceof Rockford)) {
					getTablero().setPersonaje(new LugarVacio(y, x));
				}
				getTablero().getPersonaje(y, x).explotar();
			}
		}
	}

	
	public void desaparecer() {
		tablero.setPersonaje(new LugarVacio(posicion));
	}

	public String toString() {
		return getClass().getSimpleName() + " en " + this.getPosicion();
	}
	
	public void mensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
}
