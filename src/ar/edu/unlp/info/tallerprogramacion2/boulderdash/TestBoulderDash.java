/**
 * 
 */
package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

/**
 * @author mario
 *
 */
public class TestBoulderDash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BoulderDash juego = BoulderDash.getInstance();
		juego.cargarNievel(2);
		
		
		Rockford rockford = Rockford.getInstance();
		
		//for (int i = 1 ; i < 40; i++) {
		int turno = 1;
		while (!(juego.getNivel().isFin() && (turno < 1000))) {
			
			System.out.println("Turno " + turno);
			simularTurnoRockford(turno, rockford);
			juego.ejecutarTurno();
			turno++;
		}
		
		//juego.comenzarJuego();

	}
	
	public static void simularTurnoRockford(int turno, Rockford rockford) {
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
//		case 20:
//			rockford.mover(Orientacion.DERECHA);
//			break;
//		case 21:
//			rockford.mover(Orientacion.DERECHA);
//			break;
			
		}
	}
	
}
