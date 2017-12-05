package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.controlador.TableroControlador;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Basura;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.LugarVacio;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Salida;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.Ameba;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.PersonajeAnimado;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.Diamante;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.estacionarios.Roca;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Luciernaga;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Mariposa;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.muros.Muro;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.muros.MuroTitanio;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Posicion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Tablero;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Temporizador;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.mapa.BDLevelReader;

/**
 * La clase Juego representa el juego en curso. Se encarga de cargar los niveles, manejar los turnos
 * de los personajes, mantener actualizado el tablero. Implementa el patrón Singleton, por lo que sólo se puede generar 
 * una instancia de la clase y los personajes pueden acceder a través de un método estático a dicha instancia.
 * @author Mario Jáuregui Lorda
 *
 */
public class Juego {
	
	/**
	 * Atributo estático que contiene la información del juego en curso.
	 */
	private static Juego juego;
	
	private Nivel nivelActual;
	private Tablero tablero;
	private BDLevelReader levelReader;
	private int diamantesRecogidos;
	private Salida salida;
	private Temporizador temporizador;
	private Timer timer;
	/**
	 * @return the salida
	 */
	public Salida getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(Salida salida) {
		this.salida = salida;
	}


	/**
	 * Lista de personajes animados, la cual es recorrida en cada turno para que cada personaje
	 * realice las acciones que le corresponden.
	 */
	private List<PersonajeAnimado> listaAnimados;
	/**
	 * Lista auiliar donde se cargan los personajes que se van eliminando durante un turno, que seran removidos 
	 * de la listaAnimados al finalizar el turno, para que no haya conflictos si se eliminan en el trancurso de un turno.
	 */
	private List<PersonajeAnimado> listaAnimadosEliminados;
	
	/**
	 * Lista auiliar donde se cargan los personajes que se van agregando durante un turno, 
	 * para que no haya conflictos si se agregan a la lista principal en el trancurso de un turno.
	 */
	private List<PersonajeAnimado> listaAnimadosAgregados;

	
	private Juego() {
		this.levelReader = new BDLevelReader();
		this.tablero = new Tablero();
		//this.cargarNivel(1, this.levelReader, "levels.xml");
		this.listaAnimados = new LinkedList<PersonajeAnimado>();
		this.listaAnimadosEliminados = new LinkedList<PersonajeAnimado>();
		this.listaAnimadosAgregados = new LinkedList<PersonajeAnimado>();
		this.timer = new Timer();
		
	}
	
	public static Juego getInstance() {
		if (juego == null) {
			juego = new Juego();
		}
		return juego;
		
	}
	
	public void setLevelReader(BDLevelReader levelReader) {
		this.levelReader = levelReader;
	}

	
	private void inicializarTablero(int filas, int columnas) {
		for (int fila = 0; fila < filas; fila++) {
			for (int columna = 0; columna < columnas; columna++) {
				setPersonaje(new LugarVacio(new Posicion(fila, columna)));
			}
		}
	}
	
	public void comenzarJuego() {
		this.timer = new Timer();
		this.temporizador = new Temporizador(timer, this);
		timer.schedule(this.temporizador, 0, 150);
	}
	
	public void finalizarJuego() {
		timer.cancel();
	}
	
	/**
	 * Actualiza la lista de personajes animados y la recorre haciendo ejecutar su turno a cada personaje en la lista.
	 */
	
	public void ejecutarTurno(int turno) {
		actualizarListaAnimados();
		for (PersonajeAnimado personaje : listaAnimados) {
			if (!(listaAnimadosEliminados.contains(personaje))){
				personaje.ejecutarTurno(turno);
			}
		}
		//TableroControlador.getInstance().dibujarTablero();
		//try {
			//Thread.sleep(150);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
	
	
	
	/**
	 * Actualiza la lista de personajes animados, agregando y removiendo los Personajes que fueron agregados 
	 * y eliminados de las listas auxiliares durante el turno anterior.
	 */
	private void actualizarListaAnimados() {
		for (PersonajeAnimado personaje : this.listaAnimadosEliminados) {
			this.listaAnimados.remove(personaje);
		}
		for (PersonajeAnimado personaje : this.listaAnimadosAgregados) {
			this.listaAnimados.add(personaje);
		}
		this.listaAnimadosEliminados.clear();
		this.listaAnimadosAgregados.clear();
	}
	
	
	/**
	 * Verifica que la posición a la que se va a mover el Personaje no esté fuera del tablero
	 * y en ese caso actualiza la posición del Personaje en el Tablero y crea un LugarVacio en
	 * la posición original del Personaje que se movió.
	 * @param personaje Personaje a mover.
	 * @param orientacion Orientación hacia donde se va a mover el Personaje
	 */
	public boolean moverPersonaje(Personaje personaje, Orientacion orientacion) {
		Posicion posicionDestino = personaje.getPosicion().copiar();
		posicionDestino.mover(orientacion);
		// Si no estaba en el borde del tablero
		if (!posicionDestino.equals(personaje.getPosicion())){
			Personaje lugarVacio = new LugarVacio(personaje.getPosicion().copiar());
			//getTablero().setPersonaje(lugarVacio);
			//personaje.setPosicion(posicionDestino);
			personaje.getPosicion().mover(orientacion);
			getTablero().setPersonaje(personaje);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Actualiza el tablero ubicando al personaje pasado como parámetro en la posición correspondiente,
	 *  reemplazando el que se encontraba en esa posición, y agrega y/o remueve de la lista de personajes
	 *  animados los personajes necesarios. 
	 * @param personaje Personaje a actualizar en el tablero.
	 */
	public void setPersonaje(Personaje personaje) {
		tablero.setPersonaje(personaje);
	}

	
	/**
	 * Agrega el Personaje a la lista de personajes animados
	 * @param personaje Personaje a agregar a la lista de personajes animados.
	 */
	public void agregarAListaAnimados(PersonajeAnimado personaje) {
		//if (personaje instanceof Rockford) {
		//	System.out.println("agregando a " + personaje);
		//}
		if (this.listaAnimadosEliminados.contains(personaje)) {
			this.listaAnimadosEliminados.remove(personaje);
		}
		
		if (!(this.listaAnimadosAgregados.contains(personaje)) && !(this.listaAnimados.contains(personaje))) {
			listaAnimadosAgregados.add(personaje);
		}
	}
	
	/**
	 * Remueve el Personaje de la lista de personajes animados
	 * @param personaje Personaje a remover de la lista de personajes animados.
	 */
	public void removerDeListaAnimados(PersonajeAnimado personaje) {
		listaAnimadosEliminados.add(personaje);
	}
	
	/**
	 * Obtener el personaje que se encuentra en una posición del tablero.
	 * @param posicion Posición donde buscar el Personaje.
	 * @return Devuelve el personaje en la posición pasada como parámetro.
	 */
	public Personaje getPersonaje(Posicion posicion){
		return tablero.getPersonaje(posicion);
	}

	/**
	 * Obtener el personaje que se encuentra en una posición del tablero.
	 * @param fila Fila de la posición donde buscar el Personaje.
	 * @param columna Columna de la posición donde buscar el Personaje.
	 * @return Devuelve el personaje en la ubicación del tablero indicado por los parámetros fila y columna.
	 */
	public Personaje getPersonaje(int fila, int columna){
		return tablero.getPersonaje(fila, columna);	
	}

	public void sumarDiamante(Diamante diamante) {
		diamantesRecogidos++;
		removerDeListaAnimados(diamante);
		if (diamantesRecogidos == nivelActual.getDiamantesNecesarios()) {
			getSalida().setActivada(true);	
		}
	}
	
	/**
	 * Carga un nivel del archivo indicado.
	 * @param numeroNivel Número de nivel a cargar.
	 * @param levelReader Instancia de BDLevelReader encargado de leer los niveles del archivo.
	 * @param archivo Archivo donde buscar los niveles.
	 * @return Devuelve true si se cargó el nivel, false en caso de error.
	 */
	public boolean cargarNivel(int numeroNivel, BDLevelReader levelReader, String archivo) {
		try {
			TableroControlador.getInstance().detenerAnimacion();
			this.listaAnimados.clear();
			int nivelesDisponibles = levelReader.readLevels(archivo);
				
			if ((numeroNivel > nivelesDisponibles) || (numeroNivel < 1)) {
			
				System.out.println("Nivel no disponible. Hay " + nivelesDisponibles + " niveles disponibles.");
				return false;
			} else {
				levelReader.setCurrentLevel(numeroNivel);
				//levelReader.imprimirMapa();
				this.nivelActual = new Nivel();
				
				nivelActual.setDiamantesNecesarios(levelReader.getDiamondsNeeded());
				cargarTablero(tablero, levelReader);
//					tablero = nivelActual.getTablero();
				diamantesRecogidos = 0;
				Rockford.getInstance().setMuerto(false);
				TableroControlador.getInstance().comenzarAnimacion();
				return true;
			}


			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	
	/** 
	 * Carga en un tablero la disposición de Personajes leída del nivel actual del BDLevelReader
	 * @param tablero Tablero donde cargar la disposición de personajes del nivel.
	 * @param levelReader Instancia de BDLevelReader con un nivel actual seleccionado.
	 */
	private void cargarTablero(Tablero tablero, BDLevelReader levelReader) {
		for (int fila = 0; fila < levelReader.getHEIGHT(); fila++) {
			for (int col = 0; col < levelReader.getWIDTH(); col++) {
				Posicion posicionAuxiliar = new Posicion(fila, col);
				switch (levelReader.getTile(col, fila)) {
				case EMPTY:
					new LugarVacio(posicionAuxiliar);
					break;
				case DIRT:
					new Basura(posicionAuxiliar);
					break;
				case TITANIUM:
					new MuroTitanio(posicionAuxiliar);
					break;
				case WALL:
					new Muro(posicionAuxiliar);
					break;
				case ROCK:
					new Roca(posicionAuxiliar);
					break;
				case FALLINGROCK:
					new Roca(posicionAuxiliar);
					break;
				case DIAMOND:
					new Diamante(posicionAuxiliar);
					break;
				case FALLINGDIAMOND:
					new Diamante(posicionAuxiliar);
					break;
				case AMOEBA:
					new Ameba(posicionAuxiliar);
					break;
				case FIREFLY:
					new Luciernaga(posicionAuxiliar);
					break;
				case BUTTERFLY:
					new Mariposa(posicionAuxiliar);
					break;
				case EXIT:
					this.salida = new Salida(posicionAuxiliar);
					break;
				case PLAYER:
					Rockford.getInstance(posicionAuxiliar);
					break;						
				}
			}				
		}
		
	}
	
	
	public int getDiamantesRecogidos() {
		return diamantesRecogidos;
	}

	public void setDiamantesRecogidos(int diamantesRecogidos) {
		this.diamantesRecogidos = diamantesRecogidos;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public BDLevelReader getLevelReader() {
		return levelReader;
	}

	public void setNivelActual(Nivel nivel) {
		this.nivelActual = nivel;
	}
	public Nivel getNivelActual() {
		return this.nivelActual;
	}
	


}
