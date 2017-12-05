package ar.edu.unlp.info.tallerprogramacion2.boulderdash.vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Timer;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ar.edu.unlp.info.tallerprogramacion2.boulderdash.modelo.utils.mapa.BDTile;

public class TableroVista extends JPanel {
	private int filas;
	private int columnas;
	private static TableroVista tableroVista;
	private Map<BDTile, Image> mapaImagenes;
	private BDTile[][] tablero;
	//private List<Personaje> personajesARepintar;
	//private BufferedImage fondo;
	private final int anchoImagen;
	private final int altoImagen;
	private TemporizadorVista temporizadorVista;
	private Timer timer;
	private TableroVista(int filas, int columnas, int altoImagen, int anchoImagen){
		//this.rockford = Rockford.getInstance();
		this.filas = filas;
		this.columnas = columnas;
		this.setSize(anchoImagen * columnas, altoImagen * filas);
		//this.setLayout(new GridLayout(44, 22));
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mapaImagenes = new TreeMap<BDTile, Image>();
		this.tablero = new BDTile[filas][columnas];
		this.anchoImagen = anchoImagen;
		this.altoImagen = altoImagen;
		cargarImagenes();
		//this.fondo = new BufferedImage(altoImagen * filas, anchoImagen * columnas, BufferedImage.TYPE_INT_ARGB);
		//this.personajesARepintar = new LinkedList<Personaje>();
		
		this.setVisible(true);
		

	}
	
	public static TableroVista getInstance() {
		
		if (tableroVista == null) {
			tableroVista = new TableroVista(22, 40, 32, 32);
		}
		return tableroVista;
	}
	
	
	private void cargarImagenes() {
		for (BDTile bdTile: BDTile.values()) {
			Image imagen = cargarImagen(bdTile.toString().toLowerCase());
			imagen = imagen.getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT);
			mapaImagenes.put(bdTile, imagen);
		}
		
	}

	
	private Image cargarImagen(String personaje) {
		Image imagen = null;

		URL url = getClass().getResource("imagenes/ingles/" + personaje + ".gif");
		if (url == null) {
			url = getClass().getResource("imagenes/ingles/" + personaje + ".jpg");
		}

		try {
			if (url.getPath().toString().contains(".gif")) {
				imagen = (new ImageIcon(url)).getImage();
				
			} else {
				imagen = ImageIO.read(url);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagen;
	}
	
	
	
	public void agregarPersonaje(BDTile bdTile, int fila, int columna) {
		this.tablero[fila][columna] = bdTile;
		
	}
	
	
	public void dibujarPersonaje(Graphics graphics, BDTile bdTile, int fila, int columna) {
	//public void dibujarPersonaje(Personaje personaje) {
		
		//Graphics g = fondo.getGraphics();
		
		//if (mapaImagenes.)
		if (bdTile != null) {
			Image imagen = mapaImagenes.get(bdTile);
			//Image Imagen = mapaImagenes.get(BDTile.DIAMOND);

			graphics.drawImage(imagen, columna * anchoImagen, fila * altoImagen, null);
			//graphics.dispose();		
		}
		
		//repaint();
	
		//this.personajesARepintar.add(personaje);

		//
		//Graphics g = this.getGraphics();
	//	this.repaint();
	}
	
	public void detenerAnimacion() {
		if (this.timer != null) {
			this.timer.cancel();
		}
	}
	
	public void comenzarAnimacion() {
		if (this.timer != null) {
			this.timer.cancel();
		}
		this.timer = new Timer();
		temporizadorVista = new TemporizadorVista(this.timer, this);
		timer.schedule(this.temporizadorVista, 0, 100);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	for (int x = 0; x < 40; x++) {
    		for (int y = 0; y < 22; y++) {
    			dibujarPersonaje(g, this.tablero[y][x], y, x);
    			
    		}
    	}
    	//if (fondo != null) {
    	//	g.drawImage(fondo, 0, 0, null);
    	//}
    }
	
	/**
	 * @return the filas
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * @param filas the filas to set
	 */
	public void setFilas(int filas) {
		this.filas = filas;
	}

	/**
	 * @return the columnas
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * @param columnas the columnas to set
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	/*
	@Override
	public void addKeyListener(KeyListener l) {
		super.addKeyListener(l);
		this.getParent().addKeyListener(l);
	}
	*/
	
}
