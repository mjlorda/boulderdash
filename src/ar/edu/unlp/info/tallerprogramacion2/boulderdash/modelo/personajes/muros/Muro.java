/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.muros;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.PersonajeEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.interfaces.PersonajeDeslizante;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase que representa un muro.
 * @author mario
 *
 */
public class Muro extends Personaje implements PersonajeDeslizante{
	
	public Muro(Posicion posicion) {
		super(posicion);
		
	}
	
	public boolean deslizar(Orientacion orientacion, PersonajeEstacionario personajeEstacionario) {
		Juego juego = Juego.getInstance();
		//Obtener la posicion ubicada arriba de este PersonajeDeslizante.
		Posicion posicionDestino = getPosicion().copiar().mover(Orientacion.ARRIBA);
		//Mover hacia la dirección indicada por la Orientacion recibida como parametro.
		posicionDestino.mover(orientacion);
		
		if (juego.getPersonaje(posicionDestino).ocuparLugar(personajeEstacionario)) {
			posicionDestino.mover(Orientacion.ABAJO);
			if (juego.getPersonaje(posicionDestino).ocuparLugar(personajeEstacionario)){
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
	}
	
}
