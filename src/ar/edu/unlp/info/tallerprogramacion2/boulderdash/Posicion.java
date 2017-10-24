package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

class Posicion {
	private int fila;
	private int columna;
	
	public Posicion(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}
	
	public void setFila(int fila) {
		this.fila = fila;
	}
	
	public int getColumna() {
		return columna;
	}
	
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public Posicion sumarFila(int cantidad) {
		fila = fila + cantidad;
		return this;
	}
	
	public Posicion sumarColumna(int cantidad) {
		columna = columna + cantidad;
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
