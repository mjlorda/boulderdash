/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Tablero;

/**
 * Clase que representa un nivel del juego. Contiene la información de la disposición del tablero, 
 * los diamantes necesarios, los segundos para completar el nivel y el número de nivel.
 * @author mario
 *
 */
public class Nivel {
	private int numeroNivel;
	private Tablero tablero;
	private int diamantesNecesarios;
	private int tiempo;
	
	public Nivel() {
		this.tablero = new Tablero();
	}
	
	public int getNumeroNivel() {
		return numeroNivel;
	}
	
	public void setNumeroNivel(int numeroNivel) {
		this.numeroNivel = numeroNivel;
	}

	public int getDiamantesNecesarios() {
		return diamantesNecesarios;
	}
	
	public void setDiamantesNecesarios(int diamantesNecesarios) {
		this.diamantesNecesarios = diamantesNecesarios;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}
