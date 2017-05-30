/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 18-04-2017
 * 	Vista del camino a dibujar
 * @author: Alejandro Hernandez Padron
 *
 */


package camino_aleatorio;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Vista de nuestro camino que extiende de JPanel
 *
 */
public class CaminoView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private CaminoControl control;	//Controlador de nuestro programa
	private int densidadX;			//Numero de lineas en x
	private int densidadY;			//Numero de lineas en y
	private int distancia;			//Distancia entre lineas
	private Color color;			//Color del camino recorrido
	private int x = -1, y;			//Posicion actual del recorrido

	//Matriz con nuestro recorrido
	private ArrayList<ArrayList<String>> recorrido = new ArrayList<ArrayList<String>>();

	/**
	 * Constructor por defecto
	 */
	CaminoView(){
		setColor(Color.BLUE); //Color por defecto
	}

	/**
	 * Dibujamos nuestro camino en la ventana
	 */
	public void paintComponent(Graphics g){		
		super.paintComponent(g);
		setBackground(Color.white);
		paintMapa(g);		//Dibujamos el mapa
		paintRecorrido(g);	//Dibujamos el recorrido
		paintLast(g);		//Dibujamos la posicion actual

	}


	/**
	 * Dibujamos nuestro mapa en funcion del ancho o alto del panel
	 * @param g
	 */
	public void paintMapa(Graphics g){
		
		int min = (getWidth() > getHeight()) ? getHeight() : getWidth();

		setDistancia((int)((min - 10)/ (getDensidadX()-1))); 		//Distancia entre nuestras 
		
		//Dibujamos las lineas verticales
		for (int i = 0; i < getDensidadX(); i++) {
			g.drawLine(5 + i * getDistancia(), 5, 5 + i * getDistancia(), getDistancia() * (getDensidadX()- 1) + 5);
		}

		//Dibujamos las lineas horizontales
		for (int i = 0; i < getDensidadY(); i++) {
			g.drawLine(5, 5 + i * getDistancia(), getDistancia() * (getDensidadY() - 1) + 5, 5 + i * getDistancia());
		}	
	}

	/**
	 * Dibujamos el recorrido de nuestro camino
	 * @param g
	 */
	public void paintRecorrido(Graphics g){
		Graphics2D g2 = (Graphics2D) g;		//Dibujamos un linea gruesa
		g2.setStroke(new BasicStroke(4));
		
		if(!getRecorrido().isEmpty()){					//Si nuestra matriz no esta vacia
			for (int i = 0; i < getDensidadY(); i++) {
				for (int j = 0; j < getDensidadX(); j++) {		//Dibujamos la lineas en Funcion de la letra contenidas en la posicion i j de la matriz
					int x1 = j, y1 = i;
					g2.setColor(getColor());
					if(getRecorrido().get(i).get(j).contains("N"))
						g2.drawLine(5 + j * getDistancia(), 5 + i * getDistancia(), 5 + x1 * getDistancia(), 5 + (y1 - 1) * getDistancia());
					if(getRecorrido().get(i).get(j).contains("S"))
						g2.drawLine(5 + j * getDistancia(), 5 + i * getDistancia(), 5 + x1 * getDistancia(), 5 + (y1 + 1) * getDistancia());
					if(getRecorrido().get(i).get(j).contains("E"))
						g2.drawLine(5 + j * getDistancia(), 5 + i * getDistancia(), 5 + (x1 - 1) * getDistancia(), 5 + y1 * getDistancia());
					if(getRecorrido().get(i).get(j).contains("O"))
						g2.drawLine(5 + j * getDistancia(), 5 + i * getDistancia(), 5 + (x1 + 1) * getDistancia(), 5 + y1 * getDistancia());

				}	
			}
		}
	}

	/**
	 * Dibujamos el punto actual
	 * @param g
	 */
	public void paintLast(Graphics g){
	
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(6));
		g2.setColor(Color.GREEN);
		g2.drawLine(5 + x * getDistancia(), 5 + y * getDistancia(), 5 + x * getDistancia(), 5 + y * getDistancia());
	}

	/**
	 * Seteamos el punto actual
	 * @param x
	 * @param y
	 */
	public void setLast(int x, int y){
	
			setX(x);
			setY(y);
		
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the recorrido
	 */
	public ArrayList<ArrayList<String>> getRecorrido() {
		return recorrido;
	}

	/**
	 * @param recorrido the recorrido to set
	 */
	public void setRecorrido(ArrayList<ArrayList<String>> recorrido) {
		this.recorrido = recorrido;
	}

	/**
	 * @return the distancia
	 */
	public int getDistancia() {
		return distancia;
	}

	/**
	 * @param distancia the distancia to set
	 */
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	/**
	 * @param densidadX the densidadX to set
	 */
	public void setDensidad(int densidadX, int densidadY) {

		this.densidadX = densidadX;
		this.densidadY = densidadY;
	}

	/**
	 * @return the densidadX
	 */
	public int getDensidadX() {
		return densidadX;
	}

	/**
	 * @param densidadX the densidadX to set
	 */
	public void setDensidadX(int densidadX) {
		this.densidadX = densidadX;
	}

	/**
	 * @return the densidadY
	 */
	public int getDensidadY() {
		return densidadY;
	}

	/**
	 * @param densidadY the densidadY to set
	 */
	public void setDensidadY(int densidadY) {
		this.densidadY = densidadY;
	}

	/**
	 * @return the control
	 */
	public CaminoControl getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(CaminoControl control) {
		this.control = control;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}
