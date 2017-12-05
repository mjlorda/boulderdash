package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils;

import java.util.Timer;
import java.util.TimerTask;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.Juego;

public class Temporizador extends TimerTask {

	private Timer timer;
	private Juego juego;
	private int turno = 0;
	
	public Temporizador(Timer timer, Juego juego) {
		this.timer = timer;
		this.juego = juego;
	}
	
	@Override
	public void run() {
		juego.ejecutarTurno(turno);
		turno++;
	}

	public long getTurno() {
		return turno;
	}

}
