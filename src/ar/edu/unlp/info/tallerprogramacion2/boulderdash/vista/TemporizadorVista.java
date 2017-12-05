/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.vista;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


/**
 * @author Mario Jáuregui Lorda
 *
 */
public class TemporizadorVista extends TimerTask {
	
	private Timer timer;
	private JPanel panel;
	public TemporizadorVista(Timer timer, JPanel panel) {
		this.timer = timer;
		this.panel = panel;
	}
	@Override
	public void run() {
		panel.repaint();
	}

}
