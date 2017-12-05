package ar.edu.unlp.info.tallerprogramacion2.boulderdash.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.Personaje;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;

/*public class GuiJuego extends JFrame{
	int filas;
	int columnas;
	Rockford rockford;
	private static GuiJuego pantalla;

	private GuiJuego(int filas, int columnas){
		//this.rockford = Rockford.getInstance();
		this.filas = filas;
		this.columnas = columnas;
		this.setSize(16 * columnas, 16 * filas);
		//this.setLayout(new GridLayout(44, 22));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evento) {
				switch (evento.getKeyCode()){
				case 37:
					//Rockford.getInstance().mover(Orientacion.IZQUIERDA);
					Rockford.getInstance().setOrientacion(Orientacion.IZQUIERDA);
					Rockford.getInstance().setMovimientoPendiente(true);
					Rockford.getInstance().setTeclaSoltada(false);
					break;
				case 38:
					//Rockford.getInstance().mover(Orientacion.ARRIBA);
					Rockford.getInstance().setOrientacion(Orientacion.ARRIBA);
					Rockford.getInstance().setMovimientoPendiente(true);
					Rockford.getInstance().setTeclaSoltada(false);
					break;
				case 39:
					//Rockford.getInstance().mover(Orientacion.DERECHA);
					Rockford.getInstance().setOrientacion(Orientacion.DERECHA);
					Rockford.getInstance().setMovimientoPendiente(true);
					Rockford.getInstance().setTeclaSoltada(false);
					break;
				case 40:
					//Rockford.getInstance().mover(Orientacion.ABAJO);
					Rockford.getInstance().setOrientacion(Orientacion.ABAJO);
					Rockford.getInstance().setMovimientoPendiente(true);
					Rockford.getInstance().setTeclaSoltada(false);
					break;
				}
				//System.out.println(evento.getKeyCode());
			}
		});
		
		
		this.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evento) {
				switch (evento.getKeyCode()){
				case 37:
					//Rockford.getInstance().mover(Orientacion.IZQUIERDA);
					//Rockford.getInstance().setOrientacion(Orientacion.IZQUIERDA);
					Rockford.getInstance().setTeclaSoltada(true);
					Rockford.getInstance().setMovimientoPendiente(false);
					break;
				case 38:
					//Rockford.getInstance().mover(Orientacion.ARRIBA);
					//Rockford.getInstance().setOrientacion(Orientacion.ARRIBA);
					Rockford.getInstance().setTeclaSoltada(true);
					Rockford.getInstance().setMovimientoPendiente(false);
					break;
				case 39:
					//Rockford.getInstance().mover(Orientacion.DERECHA);
					//Rockford.getInstance().setOrientacion(Orientacion.DERECHA);
					Rockford.getInstance().setTeclaSoltada(true);
					Rockford.getInstance().setMovimientoPendiente(false);
					break;
				case 40:
					//Rockford.getInstance().mover(Orientacion.ABAJO);
					//Rockford.getInstance().setOrientacion(Orientacion.ABAJO);
					Rockford.getInstance().setTeclaSoltada(true);
					Rockford.getInstance().setMovimientoPendiente(false);
					break;
				}
				//System.out.println(evento.getKeyCode());
			}
		});
		*//*
	}
	
	public static GuiJuego getInstance() {
		
		if (pantalla == null) {
			pantalla = new GuiJuego(22, 40);
		}
		return pantalla;
		
	}
	
	
	
	
	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public void setPersonaje(Personaje personaje) {
		this.getGraphics().drawImage(personaje.getImagen(), personaje.getPosicion().getColumna() * 16, personaje.getPosicion().getFila() * 16, null);
	//	this.repaint();
	}
	
	
	
	/*
	@Override
	public void paint(Graphics g) {
		
		//super.paintComponents(g);
		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				g.drawString("" + c, (c) * 16, (f + 1) * 16);
			}
		}
	}*//*
}
*/