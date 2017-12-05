/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.PersonajeAnimado;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.interfaces.PersonajeDeslizante;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.EstadoEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;

/**
 * Clase abstracta que representa a los personajes de tipo estacionario, que pueden estar en estado
 * estacionario o en estado cayendo.
 * @author mario
 *
 */
public abstract class PersonajeEstacionario extends PersonajeAnimado implements PersonajeDeslizante{
	private EstadoEstacionario estadoEstacionario;
	
	public PersonajeEstacionario(Posicion posicion) {
		super(posicion);
		this.estadoEstacionario = EstadoEstacionario.ESTACIONARIO;
	}

	public EstadoEstacionario getEstadoEstacionario() {
		return estadoEstacionario;
	}

	public void setEstadoEstacionario(EstadoEstacionario estadoEstacionario) {
		//System.out.println(this + " cambió de estado " + this.estadoEstacionario + " a estado " + estadoEstacionario);
		this.estadoEstacionario = estadoEstacionario;
	}
	
		
	
	/** 
	 * Si​ ​ la​ ​ roca​ ​ está​ ​ en​ ​ estado​ ​ “estacionario”​ ​ y ​ ​ el​ ​ casillero​ ​ ( x ​ ​ , ​ y ​ +1)​ ​ justo​ ​ abajo​ ​ está...
	 * 1. vacío:​ ​ la​ ​ roca​ ​ se​ ​ convierte​ ​ en​ ​ una​ ​ roca​ ​ “cayendo”.​ ​ (Tener​ ​ en​ ​ cuenta​ ​ que​ ​ aún​ ​ no​ ​ se​ ​ mueve)
	 * 2. muro, roca o diamante: si los casilleros (​ x ​ -1,​ y ​ ) y (​ x ​ -1,​ y ​ +1) inmediatamente a la izquierda y
	 * abajo-izquierda están ambos vacíos, la roca “se desliza” al casillero (​ x ​ -1, ​ y ​ ) a la izquierda y se
	 * convierte​ ​ en​ ​ una​ ​ roca​ ​ “cayendo”​ ​ (La​ ​ regla​ ​ también​ ​ aplica​ ​ si​ ​ consideramos​ ​ el​ ​ lado​ ​ derecho).
	 * 3. cualquier​ ​ otra​ ​ cosa:​ ​ la​ ​ roca​ ​ permanece​ ​ “estacionaria”.
	 * Si​ ​ la​ ​ roca​ ​ está​ ​ actualmente​ ​ “cayendo”​ ​ y ​ ​ el​ ​ casillero​ ​ justo​ ​ debajo​ ​ es....
	 * 1. vacío:​ ​ la​ ​ roca​ ​ se​ ​ mueve​ ​ al​ ​ casillero​ ​ que​ ​ se​ ​ encontraba​ ​ abajo​ ​ de​ ​ la​ ​ misma.
	 * 2. jugador​ ( ​ Rockford):​ ​ el​ ​ jugador​ ​ explota​ ​ y ​ ​ muere.
	 * 3. luciérnaga: la luciérnaga explota y cualquier cosa que se encuentre en un área de 3*3 que no
	 * sea un muro, se transforma en un espacio vacío. Las explosiones NO continúan
	 *  recursivamente​ ​ aún​ ​ si​ ​ hay​ ​ otra​ ​ luciérnaga​ ​ o ​ ​ mariposa​ ​ en​ ​ el​ ​ área​ ​ de​ ​ la​ ​ explosión.
	 * 4. mariposa: la mariposa explota y cualquier cosa que se encuentre en un área de 3*3 que no
	 * sea​ ​ un​ ​ muro​ ​ se​ ​ convierte​ ​ en​ ​ diamante.​ ​ (Las​ ​ explosiones​ ​ NO​ ​ continúan​ ​ recursivamente.)
	 * 5. cualquier​ ​ otra​ ​ cosa:​ ​ la​ ​ roca​ ​ se​ ​ vuelve​ ​ “estacionaria”.
	 * 
	 */
	public void ejecutarTurno(int turno) {
		Juego juego = Juego.getInstance();
		Posicion posicionAbajo = getPosicion().copiar().mover(Orientacion.ABAJO);
			
		Personaje personajeAbajo = juego.getPersonaje(posicionAbajo);
		
		if (getEstadoEstacionario() == EstadoEstacionario.ESTACIONARIO) {
			//El unico que devuelve true es LugarVacio, por lo tanto pasa a estado CAYENDO
			if (personajeAbajo.ocuparLugar(this)) {
				this.setEstadoEstacionario(EstadoEstacionario.CAYENDO);
			} else {
				if (personajeAbajo.deslizar(Orientacion.IZQUIERDA, this)) {
					Juego.getInstance().moverPersonaje(this, Orientacion.IZQUIERDA);
					//this.getPosicion().mover(Orientacion.IZQUIERDA);
				} else if (personajeAbajo.deslizar(Orientacion.DERECHA, this)) {
					Juego.getInstance().moverPersonaje(this, Orientacion.DERECHA);
					//this.getPosicion().mover(Orientacion.DERECHA);
				}
			}
		} else {
			//Si esta en estado CAYENDO y el lugar de abajo lo permite, caer un lugar, si no, pasa a estado ESTACIONARIO
			if (personajeAbajo.ocuparLugar(this)) {
				Juego.getInstance().moverPersonaje(this, Orientacion.ABAJO);
			} else {
				this.setEstadoEstacionario(EstadoEstacionario.ESTACIONARIO);
			}
		}
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
	
	
/*	public void ejecutarTurno() {
		Juego juego = Juego.getInstance();
		int filaActual, columnaActual;
		filaActual = getPosicion().getFila();
		columnaActual = getPosicion().getColumna();
		Personaje personajeAbajo = juego.getPersonaje(filaActual + 1, columnaActual);
		
		if (getEstadoEstacionario() == EstadoEstacionario.ESTACIONARIO) {
			if (personajeAbajo instanceof LugarVacio) {
				this.setEstadoEstacionario(EstadoEstacionario.CAYENDO);	
			} else if ((personajeAbajo instanceof PersonajeEstacionario) || (personajeAbajo instanceof Muro)){
				Personaje personajeIzquierda = juego.getPersonaje(filaActual, columnaActual - 1);
				Personaje personajeAbajoIzquierda = juego.getPersonaje(new Posicion(filaActual
						+ 1, columnaActual - 1));
                				
				if ((personajeIzquierda instanceof LugarVacio) && (personajeAbajoIzquierda instanceof LugarVacio)) {
					this.setPosicion(filaActual, columnaActual - 1);
					this.setEstadoEstacionario(EstadoEstacionario.CAYENDO);
					
				} else {
					Personaje personajeDerecha = juego.getPersonaje(filaActual, columnaActual + 1);
					Personaje personajeAbajoDerecha = juego.getPersonaje(filaActual + 1, columnaActual + 1);
					if ((personajeDerecha instanceof LugarVacio) && (personajeAbajoDerecha instanceof LugarVacio)) {
						this.setPosicion(new Posicion(filaActual, columnaActual + 1));
						this.setEstadoEstacionario(EstadoEstacionario.CAYENDO);
					}
				}
			}
		} else {
			//Si esta CAYENDO
			if (personajeAbajo instanceof LugarVacio) {
				this.setPosicion(filaActual + 1, columnaActual);
			//si abajo hay un PersonajeOrientable (Rockford, Luciernaga o Mariposa) hacerlo explotar	
			} else if (personajeAbajo instanceof PersonajeOrientable) {
				personajeAbajo.explotar();
			} else {
				this.setEstadoEstacionario(EstadoEstacionario.ESTACIONARIO);
			}
		}
	}
	*/
}
