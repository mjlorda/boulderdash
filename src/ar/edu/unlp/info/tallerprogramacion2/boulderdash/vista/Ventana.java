/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;

/**
 * @author Mario Jáuregui Lorda
 *
 */
public class Ventana extends JFrame {
	TableroVista tableroVista;
	
	public Ventana() {
		
		this.tableroVista = TableroVista.getInstance();
		this.setSize(32 * 40, 32 * 22);
		this.add(tableroVista);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
