package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

public class Ameba extends Personaje {
	private Posicion[] posiciones;
	
	public Ameba(Posicion posicion) {
		super(posicion);
		
	}
	//public void explotarMariposa(Mariposa) {
	public void crecer() {
		//ToDo: comportamiento para que crezca en forma aleatoria
		
		System.out.println("La ameba se expandió a la posicion " + posiciones[posiciones.length].toString());
	}
}


