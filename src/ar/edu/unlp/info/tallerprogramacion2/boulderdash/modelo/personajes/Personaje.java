package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.Ameba;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.PersonajeEstacionario;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Enemigo;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;


/**
 * Clase abstracta que representa un personaje del juego. De esta clase 
 * extienden todos los personajes que puede contener un casillero del tablero.
 * 
 * @author Mario Jáuregui Lorda
 *
 */
public abstract class Personaje {
	private BufferedImage imagen;
	private Posicion posicion;
	
	public Personaje(Posicion posicion) {
		this.posicion = posicion;
		/*if (this.imagen == null) {
			String clase = getClass().getSimpleName();
			URL url = getClass().getClassLoader().getResource("imagenes/" + clase + ".gif");
			if (url == null) {
				url = getClass().getResource("imagenes/" + getClass().getSimpleName() + ".jpg");
			}
			//ClassLoader cl = getClass().getClassLoader();
			
			//url = getClass().getClassLoader().getResource("ameba.png");
			//File file = new File("Rockford.gif");
			
			try {
				imagen = ImageIO.read(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}*/
		Juego.getInstance().setPersonaje(this);
		
		//System.out.println("Se creó el personaje " + this);
		
	}
	
	public Image getImagen() {
		return imagen;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	
	/**
	 * Asigna la posición al personaje y se lo comunica a la clase Juego 
	 * para que se encargue de la lógica que implica esta acción.
	 * @param posicion Objeto de tipo Posicion el cual se va a asignar al personaje.
	 */
	protected void setPosicion(Posicion posicion) {
		
		this.posicion = posicion;
		Juego.getInstance().setPersonaje(this);
		
	}
	
	
	/**
	 * Método polimórfico que evalúa si el Personaje puede 
	 * recibir un PersonajeEstcionario y realiza las acciones
	 * correspondientes.
	 * @param personaje PersonajeEstacionario que intenta ocupar la posición.
	 * @return Devuelve true en caso que el personaje acepte recibir el PersonajeEstacionario, 
	 * false en caso contrario.
	 */
	public boolean ocuparLugar(Rockford rockford) {
		return false;
	}
	public boolean ocuparLugar(PersonajeEstacionario personajeEstacionario) {
		return false;
	}
	
	public boolean ocuparLugar(Enemigo enemigo) {
		return false;
	}
	
	public boolean ocuparLugar(Ameba ameba) {
		return false;
	}


	
	
	/**
	 * Determina si es posible deslizar un Personaje Estacionario sobre este personaje hacia 
	 * la dirección indicada por el parámetro.
	 * @param orientacion Oriencación que indica hacia donde se intenta deslizar el Personaje Estacionario
	 * @return Devuelve true si se puede deslizar el Personaje Estacionario.
	 */
	public boolean deslizar(Orientacion orientacion, PersonajeEstacionario personajeEstacionario) {
		return false;
	}


	/**
	 * Realiza la acción de explotar el personaje y deja un espacion vacío.
	 */
	public void explotar() {
		System.out.println(this + " explotó");
		Juego.getInstance().setPersonaje(new LugarVacio(getPosicion()));
	}
	
	
	/** Representación en String del objeto.
	 * @return Retorna el nombre de la clase y la posición dentro del tablero.
	 */
	public String toString() {
		return getClass().getSimpleName() + " en " + this.getPosicion();
	}
			
	/**
	 * Compara la clase del objeto pasado como parámetro con la de este personaje
	 * y si son de la misma clase compara las posiciones.
	 * @param o Objeto a comparar
	 * @return Retorna true si es de la misma clase y esta ubicado en la misma posición, y false en 
	 * caso contrario.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o == null)) {
			if (o.getClass() == this.getClass()) {
				
				if (((Personaje) o).getPosicion().equals(this.posicion)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
}
