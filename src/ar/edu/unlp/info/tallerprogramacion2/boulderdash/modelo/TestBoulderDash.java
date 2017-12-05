/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

//import ar.edu.unlp.info.tallerprogramacion2.boulderdash.gui.GuiJuego;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.personajes.animados.orientables.Rockford;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.Orientacion;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.vista.TableroVista;
import ar.edu.unlp.info.tallerprogramacion2.boulderdash.vista.Ventana;

/**
 * Clase para probar los niveles 1 y 2
 * @author mario
 *
 */
public class TestBoulderDash {

	public static void main(String[] args) {		
		
		Juego juego = Juego.getInstance();
		int numeroNivel = 1;
		int turno = 1;

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nivel que desea jugar:");
		numeroNivel = sc.nextInt();
		while (numeroNivel != 999) {
			juego.cargarNivel(numeroNivel, juego.getLevelReader(), "levels.xml");
			juego.comenzarJuego();
			System.out.println("Ingrese el nivel que desea jugar:");
			numeroNivel = sc.nextInt();
			juego.finalizarJuego();
			
		}

	}
	
	
	public static void simularTurnoRockford(int nivel, int turno, Rockford rockford) {
		if (nivel == 1) {
			switch (turno) {
			case 1:
				rockford.mover(Orientacion.ABAJO);
				break;
			case 2:
				rockford.mover(Orientacion.DERECHA);			
				break;
			case 3:
				rockford.mover(Orientacion.DERECHA);			
				break;
			case 4:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 5:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 6:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 7:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 8:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 9:
				rockford.mover(Orientacion.ARRIBA);
				break;
			case 10:
				rockford.mover(Orientacion.ARRIBA);
				break;
			case 11:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 12:
				rockford.mover(Orientacion.ABAJO);
				break;
			case 13:
				rockford.mover(Orientacion.ABAJO);
				break;
			case 14:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 15:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 16:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 17:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 18:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 19:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 20:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 21:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 22:
				rockford.mover(Orientacion.ABAJO);
				break;
			case 23:
				rockford.mover(Orientacion.ABAJO);
				break;
			case 24:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 25:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 26:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 27:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 28:
				rockford.mover(Orientacion.DERECHA);
				break;
			}
		}
		
			
		
		if (nivel == 2) {

		
			switch (turno) {
			case 1:
				rockford.mover(Orientacion.DERECHA);
				break;
			case 2:
				rockford.mover(Orientacion.ARRIBA);			
				break;
			case 3:
				rockford.mover(Orientacion.ARRIBA);			
				break;
			case 4:
				rockford.mover(Orientacion.ARRIBA);
				break;
			case 5:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 6:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 7:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 8:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 9:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 10:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 11:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 12:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 13:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 14:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 15:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 16:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 17:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 18:
				rockford.mover(Orientacion.IZQUIERDA);
				break;
			case 19:
				rockford.mover(Orientacion.ARRIBA);
				break;
			}
			
		}
	}
	
}	

