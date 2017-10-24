package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

public class LugarVacio extends Personaje {
	
	public LugarVacio(Posicion posicion) {
		super(posicion);
	}

	public LugarVacio(int fila, int columna) {
		super(fila, columna);

	}
	
	@Override
	public void explotar() {
		mensaje(this + " explotó");
		
	}
}
