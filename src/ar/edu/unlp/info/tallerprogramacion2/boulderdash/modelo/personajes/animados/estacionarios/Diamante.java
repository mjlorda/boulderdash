/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa un diamante
 * @author mario
 *
 */
public class Diamante extends PersonajeEstacionario{	
	
	public Diamante(Posicion posicion) {
		super(posicion);
	}
	
	@Override
	public boolean ocuparLugar(Rockford rockford) {
		Juego.getInstance().sumarDiamante(this);
		return true;
	}
	
}
