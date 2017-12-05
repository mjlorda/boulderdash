/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.interfaces;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.PersonajeEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;

/**
 * Interface que representa los Personajes sobre los cuales se pueden deslizar los Personajes Estacionarios.
 * @author Mario Jáuregui Lorda
 *
 */
public interface PersonajeDeslizante {
	public boolean deslizar(Orientacion orientacion, PersonajeEstacionario personajeEstacionario);
}
