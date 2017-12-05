package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils;

/**
 * Clase que representa una posición en el tablero del juego.
 * @author Mario Jáuregui Lorda
 *
 */
public class Posicion {
	private final int COLUMNAS = 40;
	private final int FILAS = 22;
	private int fila;
	private int columna;
	
	
	/**
	 * Constructor
	 * @param fila Fila de la posicióń. La primer fila es la fila 0.
	 * @param columna Columna de la posición. La primer columna es la columna 0.
	 */
	public Posicion(int fila, int columna) {
		setFila(fila);
		setColumna(columna);
	}

	public int getFila() {
		return fila;
	}
	
	private void setFila(int fila) {
		if (fila < 0) {
			this.fila = 0;
			
		} else if (fila > FILAS) {
			this.fila = FILAS;
		} else {
			this.fila = fila;
		}
	}
	
	public int getColumna() {
		return columna;
	}
	
	private void setColumna(int columna) {
		if (columna < 0) {
			this.columna = 0;
			
		} else if (columna > COLUMNAS) {
			this.columna = COLUMNAS;
		} else {
			this.columna = columna;
		}
	}

	public Posicion copiar() {
		return new Posicion(getFila(), getColumna());
	}
	
	public Posicion mover(Orientacion orientacion) {
		switch (orientacion) {
		case ARRIBA:
			setFila(getFila() - 1);
			break;
		case ABAJO:
			setFila(getFila() + 1);
			break;
		case IZQUIERDA:
			setColumna(getColumna() -1);
			break;
		case DERECHA:
			setColumna(getColumna() + 1);
			break;
		}
		return this;
	}
	
	@Override 
	public boolean equals(Object o) {
		if ((o instanceof Posicion) && (((Posicion)o).getFila() == this.getFila()) && (((Posicion)o).getColumna() == this.getColumna())) {
			return true;
			
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "(" + String.valueOf(fila) + ", " + String.valueOf(columna) + ")";
	}

}
