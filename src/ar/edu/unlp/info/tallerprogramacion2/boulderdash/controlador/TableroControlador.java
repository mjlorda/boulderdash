package ar.edu.unlp.info.tallerprogramacion2.boulderdash.controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.mapa.BDTile;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.vista.TableroVista;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.vista.Ventana;

public class TableroControlador {
	
	private static TableroControlador tableroControlador;
	private Ventana ventana;
	private Rockford rockford;

	private TableroControlador() {
		//this.rockford = Rockford.getInstance();
		this.ventana = new Ventana();
		
		registrarListeners();
	}
	
	public static TableroControlador getInstance() {
		if (tableroControlador == null) {
			tableroControlador = new TableroControlador();
		}
		return tableroControlador;
	}
	
	private void registrarListeners() {
		ventana.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evento) {
				switch (evento.getKeyCode()){
				case 37:
					comenzarMovimiento(Orientacion.IZQUIERDA);
					//setTeclaIzquierdaPresionada(true);
					//Rockford.getInstance().mover(Orientacion.IZQUIERDA);
					//Rockford.getInstance().setOrientacion(Orientacion.IZQUIERDA);
					//Rockford.getInstance().setMovimientoPendiente(true);
					//Rockford.getInstance().setTeclaSoltada(false);
					break;
				case 38:
					comenzarMovimiento(Orientacion.ARRIBA);
					//setTeclaArribaPresionada(true);
					//Rockford.getInstance().mover(Orientacion.ARRIBA);
					//Rockford.getInstance().setOrientacion(Orientacion.ARRIBA);
					//Rockford.getInstance().setMovimientoPendiente(true);
					//Rockford.getInstance().setTeclaSoltada(false);
					break;
				case 39:
					comenzarMovimiento(Orientacion.DERECHA);
					//setTeclaDerechaPresionada(true);
					//Rockford.getInstance().mover(Orientacion.DERECHA);
					//Rockford.getInstance().setOrientacion(Orientacion.DERECHA);
					//Rockford.getInstance().setMovimientoPendiente(true);
					//Rockford.getInstance().setTeclaSoltada(false);
					break;
				case 40:
					comenzarMovimiento(Orientacion.ABAJO);
					//setTeclaAbajoPresionada(true);
					//Rockford.getInstance().mover(Orientacion.ABAJO);
					//Rockford.getInstance().setOrientacion(Orientacion.ABAJO);
					//Rockford.getInstance().setMovimientoPendiente(true);
					//Rockford.getInstance().setTeclaSoltada(false);
					break;
				}
				//System.out.println(evento.getKeyCode());
			}
			
			});
		
		ventana.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evento) {
				switch (evento.getKeyCode()){
				case 37:
					finalizarMovimiento(Orientacion.IZQUIERDA);
					//setTeclaIzquierdaPresionada(false);
					//Rockford.getInstance().mover(Orientacion.IZQUIERDA);
					//Rockford.getInstance().setOrientacion(Orientacion.IZQUIERDA);
					//Rockford.getInstance().setTeclaSoltada(true);
					//Rockford.getInstance().setMovimientoPendiente(false);
					break;
				case 38:
					finalizarMovimiento(Orientacion.ARRIBA);
					//setTeclaArribaPresionada(false);
					//Rockford.getInstance().mover(Orientacion.ARRIBA);
					//Rockford.getInstance().setOrientacion(Orientacion.ARRIBA);
					//Rockford.getInstance().setTeclaSoltada(true);
					//Rockford.getInstance().setMovimientoPendiente(false);
					break;
				case 39:
					finalizarMovimiento(Orientacion.DERECHA);
					//setTeclaDerechaPresionada(false);
					//Rockford.getInstance().mover(Orientacion.DERECHA);
					//Rockford.getInstance().setOrientacion(Orientacion.DERECHA);
					//Rockford.getInstance().setTeclaSoltada(true);
					//Rockford.getInstance().setMovimientoPendiente(false);
					break;
				case 40:
					finalizarMovimiento(Orientacion.ABAJO);
					//setTeclaAbajoPresionada(false);
					//Rockford.getInstance().mover(Orientacion.ABAJO);
					//Rockford.getInstance().setOrientacion(Orientacion.ABAJO);
					//Rockford.getInstance().setTeclaSoltada(true);
					//Rockford.getInstance().setMovimientoPendiente(false);
					break;
				}
				//System.out.println(evento.getKeyCode());
			}
		
		});

	}
		
	private void finalizarMovimiento(Orientacion orientacion) {
		Rockford.getInstance().finalizarMovimiento(orientacion);
	}
	private void comenzarMovimiento(Orientacion orientacion) {
		Rockford.getInstance().comenzarMovimiento(orientacion);
	}
	
	public void comenzarAnimacion() {
		TableroVista.getInstance().comenzarAnimacion();
	}
	public void detenerAnimacion() {
		TableroVista.getInstance().detenerAnimacion();
	}


	public void dibujarPersonaje(Personaje personaje) {
		BDTile bdTile;
		switch (personaje.getClass().getSimpleName()) {
		
		case "Rockford":
			bdTile = BDTile.PLAYER;
			break;
		case "Mariposa":
			bdTile = BDTile.BUTTERFLY;
		break;
		case "Luciernaga":
			bdTile = BDTile.FIREFLY;
		break;
		case "Roca":
			bdTile = BDTile.ROCK;
		break;
		case "Diamante":
			bdTile = BDTile.DIAMOND;
		break;
		case "Basura":
			bdTile = BDTile.DIRT;
		break;
		case "LugarVacio":
			bdTile = BDTile.EMPTY;
		break;
		case "Muro":
			bdTile = BDTile.WALL;
		break;
		case "MuroMagico":
			bdTile = BDTile.WALL;
		break;
		case "MuroTitanio":
			bdTile = BDTile.TITANIUM;
		break;
		case "Salida":
			bdTile = BDTile.EXIT;
		break;
		case "Ameba":
			bdTile = BDTile.AMOEBA;
		break;
		default:
			bdTile = BDTile.EMPTY;
		}
		
		TableroVista.getInstance().agregarPersonaje(bdTile, personaje.getPosicion().getFila(), personaje.getPosicion().getColumna());
		//TableroVista.getInstance().dibujarPersonaje(personaje);
		
	}
	
}
