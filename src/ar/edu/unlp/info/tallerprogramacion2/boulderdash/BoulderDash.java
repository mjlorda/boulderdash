package ar.edu.unlp.info.tallerprogramacion2.boulderdash;

import java.util.ArrayList;
import java.util.List;

import mapa.BDLevelReader;

public class BoulderDash {
	
	private static BoulderDash juego;
	private Tablero tablero;
	private Nivel nivel;
	private BDLevelReader levelReader;
	private static BoulderDash boulderDash;
	private boolean rockforSeMurio;
	private BoulderDash() {
		tablero = Tablero.getInstance();
	}
	
	public static BoulderDash getInstance() {
		if (boulderDash == null) {
			boulderDash = new BoulderDash();
		}
		return boulderDash;
		
	}
	
	public void comenzarJuego() {
		int turno = 0;
		while (!nivel.isFin() && turno < 100) {
			System.out.println("Turno numero " + turno);
			ejecutarTurno();
			turno++;
		}
		
	}

	public void ejecutarTurno() {
		for (int fila = 0; fila < tablero.FILAS; fila++) {
			for (int columna = 0; columna < tablero.COLUMNAS; columna++) {
				Personaje personaje = tablero.getPersonaje(new Posicion(fila, columna));
				if (personaje instanceof PersonajeAnimado){
					((PersonajeAnimado)personaje).ejecutarTurno();
				}
			}
		}
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public Nivel getNivel() {
		return this.nivel;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public void sumarDiamante() {
		
	}
	public boolean cargarNievel(int numeroNivel) {
		BDLevelReader levelReader = new BDLevelReader();
		try {
			int nivelesDisponibles = levelReader.readLevels("levels.xml");
		
			if ((numeroNivel > nivelesDisponibles) || (numeroNivel < 0)) {
				System.out.println("Nivel no disponible. Hay " + nivelesDisponibles + " niveles disponibles.");
				return false;
			} else {
				
				levelReader.setCurrentLevel(numeroNivel);
				Nivel nivel = new Nivel();
				nivel.setDiamantesNecesarios(levelReader.getDiamondsNeeded());
				cargarTablero(levelReader);
				nivel.setDisposicionInicial(tablero);
				this.setNivel(nivel);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	private void cargarTablero(BDLevelReader levelReader) {
		for (int fila = 0; fila < levelReader.getHEIGHT(); fila++) {
			for (int col = 0; col < levelReader.getWIDTH(); col++) {
				Posicion posicionAuxiliar = new Posicion(0, 0);
				posicionAuxiliar.setFila(fila);
				posicionAuxiliar.setColumna(col);
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
					new Salida(posicionAuxiliar);
					break;
				case PLAYER:
					Rockford.getInstance(posicionAuxiliar);
					break;						
				}
			}				
		}
		
	}
	
	
}
