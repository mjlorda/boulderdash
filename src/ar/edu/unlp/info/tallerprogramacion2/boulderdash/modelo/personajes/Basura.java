/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes;

import java.awt.Image;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.Ameba;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa basura en un casillero.
 * @author mario
 *
 */
public class Basura extends Personaje {

	private static Image imagen;
	public Basura(Posicion posicion) {
		super(posicion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ocuparLugar(Rockford rockford) {
		return true;
	}
	
	@Override
	public boolean ocuparLugar(Ameba ameba) {
		return true;
	}
	
	
}
