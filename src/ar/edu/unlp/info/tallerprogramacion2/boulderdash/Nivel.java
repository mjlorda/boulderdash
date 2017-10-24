/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

/**
 * @author mario
 *
 */
public class Nivel {
	private int numeroNivel;
	private Tablero tablero;
	private int diamantesNecesarios;
	private int diamantesRecogidos;
	private int segundos;
	private boolean fin;
	
	public int getNumeroNivel() {
		return numeroNivel;
	}
	public void setNumeroNivel(int numeroNivel) {
		this.numeroNivel = numeroNivel;
	}
	public Tablero getDisposicionInicial() {
		return tablero;
	}
	public void setDisposicionInicial(Tablero disposicionInicial) {
		this.tablero = disposicionInicial;
	}
	public int getDiamantesNecesarios() {
		return diamantesNecesarios;
	}
	public void setDiamantesNecesarios(int diamantesNecesarios) {
		this.diamantesNecesarios = diamantesNecesarios;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	public int getDiamantesRecogidos() {
		return diamantesRecogidos;
	}
	public void setDiamantesRecogidos(int diamantesRecogidos) {
		this.diamantesRecogidos = diamantesRecogidos;
	}
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		System.out.println("Juego terminado");
		this.fin = fin;
	}
	

}
