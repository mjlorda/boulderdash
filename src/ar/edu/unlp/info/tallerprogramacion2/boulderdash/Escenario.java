package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

class Escenario {
	private Casillero[][] casilleros;
	private final int FILAS = 22;
	private final int COLUMNAS = 40;
	
	public Escenario() {
		this.casilleros = new Casillero[COLUMNAS][FILAS];
	}

	public Casillero[][] getCasilleros() {
		return casilleros;
	}

	public void setCasilleros(Casillero[][] casilleros) {
		this.casilleros = casilleros;
	}
	
	public Personaje getPersonaje(Posicion posicion) {
		return this.casilleros[posicion.getFila()][posicion.getColumna()].getPersonaje();
	}

}
