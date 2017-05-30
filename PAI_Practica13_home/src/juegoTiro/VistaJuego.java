/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informï¿½tica
 * 	Fecha: 4-05-2017
 * 	Juego de bolas de colores
 * @author: Alejandro Hernandez Padron
 *
 */
package juegoTiro;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Clase que dibuja nuestras bolas de la fila
 * superior, la de disparo y el centro, ademas del
 * angulo de disparo, informa al controlador
 * de la posicion del raton en el panel
 *
 */
public class VistaJuego extends JPanel{

	private static final long serialVersionUID = 1L;
	private Controlador control;

	//Bolas de la parte superior
	private ArrayList<Color> colorBola = new ArrayList<>();
	private ArrayList<Boolean> dibBolas = new ArrayList<>();
	private ArrayList<Ellipse2D> bolas = new ArrayList<>();

	//Centro y disparo de nuestro juego
	private Ellipse2D tiro;
	private Ellipse2D centro;
	private Color colorTiro;
	private Color colorCentro;

	//Valores iniciales
	private int angulo = 90;
	private int longitudF = 100; //Longitud de flecha
	private int diametro = 40;
	Point2D center;

	//Constructor por defecto
	public VistaJuego() {

	}

	/**
	 * Metodo que va dibujando nuestras bolas 
	 * con el disparo centro y el angulo actual de nuestro
	 * raton con el centro
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.CYAN);
		dibujaBolas(g);
		dibujaFlecha(g);
	}

	/**
	 * Metodo que dibuja nuestras todas las bolas
	 * en funcion de si las de la parte superior
	 *  son dibujables y ademas dibuja el centro y el tiro  
	 * @param g
	 */
	public void dibujaBolas(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		for (int i = 0; i < bolas.size(); i++) {
			g2d.setColor(colorBola.get(i));
			if(dibBolas.get(i)){		//if true dibuja
				Shape bola = bolas.get(i);
				g2d.fill(bola);
			}
			g2d.setColor(colorTiro);
			g2d.fill(tiro);
			g2d.setColor(colorCentro);
			g2d.fill(centro);
		}
	}

	/**
	 * Dibuja nuestra flecha
	 * con su punta en funcion del angulo que forma con
	 * el centro
	 * @param g
	 */
	public void dibujaFlecha(Graphics g){
		Graphics2D g2D=(Graphics2D)g;
		g2D.setStroke (new BasicStroke(1.5f));
		int auxX = (int) (longitudF * Math.cos(Math.toRadians(angulo)) + getWidth()/2);
		int auxY = (int) (longitudF * Math.sin(Math.toRadians(angulo)) + getHeight() - 10 - diametro/2);
		g2D.drawLine( getWidth()/2, getHeight() - 10 - diametro/2, auxX, auxY);
		dibujaFlecha(g2D, getWidth()/2, getHeight() - 10 - diametro/2, auxX, auxY);
	}

	/**
	 * Dibuajos la punta de la flecha a partir del angulo que
	 * @param g2
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	private void dibujaFlecha(Graphics2D g2, int x1, int y1, int x2, int y2){
		double phi = Math.toRadians(20);;
		double dy = y2 - y1;
		double dx = x2 - x1;
		double theta = Math.atan2(dy, dx);
		double x, y, rho = theta + phi;
		for(int j = 0; j < 2; j++){
			x = x2 - 15 * Math.cos(rho);
			y = y2 - 15* Math.sin(rho);
			g2.draw(new Line2D.Double(x2, y2, x, y));
			rho = theta - phi;
		}
	}



	/**
	 * @return the colorTiro
	 */
	public Color getColorTiro() {
		return colorTiro;
	}

	/**
	 * @param colorTiro the colorTiro to set
	 */
	public void setColorTiro(Color colorTiro) {
		this.colorTiro = colorTiro;
	}

	/**
	 * @return the colorCentro
	 */
	public Color getColorCentro() {
		return colorCentro;
	}

	/**
	 * @param colorCentro the colorCentro to set
	 */
	public void setColorCentro(Color colorCentro) {
		this.colorCentro = colorCentro;
	}

	/**
	 * @return the tiro
	 */
	public Ellipse2D getTiro() {
		return tiro;
	}

	/**
	 * @param tiro the tiro to set
	 */
	public void setTiro(Ellipse2D tiro) {
		this.tiro = tiro;
	}

	/**
	 * @return the centro
	 */
	public Ellipse2D getCentro() {
		return centro;
	}

	/**
	 * @param centro the centro to set
	 */
	public void setCentro(Ellipse2D centro) {
		this.centro = centro;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the control
	 */
	public Controlador getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(Controlador control) {
		addMouseListener(control);
		addMouseMotionListener(control);
		this.control = control;
	}

	/**
	 * @return the colorBola
	 */
	public ArrayList<Color> getColorBola() {
		return colorBola;
	}

	/**
	 * @param colorBola the colorBola to set
	 */
	public void setColorBola(ArrayList<Color> colorBola) {
		this.colorBola = colorBola;
	}

	/**
	 * @return the dibBolas
	 */
	public ArrayList<Boolean> getDibBolas() {
		return dibBolas;
	}

	/**
	 * @param dibBolas the dibBolas to set
	 */
	public void setDibBolas(ArrayList<Boolean> dibBolas) {
		this.dibBolas = dibBolas;
	}

	/**
	 * @return the bolas
	 */
	public ArrayList<Ellipse2D> getBolas() {
		return bolas;
	}

	/**
	 * @param bolas the bolas to set
	 */
	public void setBolas(ArrayList<Ellipse2D> bolas) {
		this.bolas = bolas;
	}

	/**
	 * @return the angulo
	 */
	public int getAngulo() {
		return angulo;
	}

	/**
	 * @param angulo the angulo to set
	 */
	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	/**
	 * @return the longitudF
	 */
	public int getLongitudF() {
		return longitudF;
	}

	/**
	 * @param longitudF the longitudF to set
	 */
	public void setLongitudF(int longitudF) {
		this.longitudF = longitudF;
	}

	/**
	 * @return the diametro
	 */
	public int getDiametro() {
		return diametro;
	}

	/**
	 * @param diametro the diametro to set
	 */
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}



	public Point2D getCenter() {
		return center;
	}

	/**
	 * @param center the center to set
	 */
	public void setCenter(Point2D center) {
		this.center = center;
	}



}
