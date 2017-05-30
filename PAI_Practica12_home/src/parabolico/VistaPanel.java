/**
s * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 4-05-2017
 * 	Vista del Panel de informacion de nuestro tiro
 * @author: Alejandro Hernandez Padron
 *
 */
package parabolico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Clase que a partir de nuestros datos del modelo 
 * va actualizando la informacion que se meustra en
 * la pantalla del lanzamiento actual
 *
 */
public class VistaPanel extends JPanel{
	ControlTiro control;
	private double tiempo = 0;
	private int x = 0;
	private int y = 0;
	private double vx = 0;
	private double vy = 0;
	private	double v = 50;
	private	int yMax = 0;	
	
	/**
	 * Contiene todos los datos a mostrar en nuestro
	 * panel de dibujo
	 */
	
	
	VistaPanel(){}

	/**
	 * Dibuja en nuestro panel toda la informacion del modelo
	 * a partir del panel de dibujo g
	 * utiliza Gtaphics2D para la letra y la fuente
	 * @param g
	 * @param ancho
	 * @param alto
	 */
	public void dibujaPanel(Graphics g, int ancho, int alto){
		
		Graphics2D g2D=(Graphics2D)g;
		g2D.setColor(Color.BLACK);
		g2D.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
		g2D.drawString("t = " + String.format("%1$,.2f", tiempo), ancho - 100, 40);
		g2D.drawString("x = " + x, ancho - 100, 60);
		g2D.drawString("y = " + y, ancho - 100, 80);
		g2D.drawString("vx = " + String.format("%1$,.2f", vx), ancho - 100, 100);
		g2D.drawString("vy = " + String.format("%1$,.2f", vy), ancho - 100, 120);
		g2D.drawString("v = " + String.format("%1$,.2f", v), ancho - 100, 140);
		g2D.drawString("yMax = " + yMax, ancho - 100, 160);
//		
	}

	/**
	 * @return the control
	 */
	public ControlTiro getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(ControlTiro control) {
		this.control = control;
	}

	/**
	 * @return the tiempo
	 */
	public double getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
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
		if(y > getyMax())
			setyMax(y);
		this.y = y;
	}

	/**
	 * @return the vx
	 */
	public double getVx() {
		return vx;
	}

	/**
	 * @param vx the vx to set
	 */
	public void setVx(double vx) {
		this.vx = vx;
	}

	/**
	 * @return the vy
	 */
	public double getVy() {
		return vy;
	}

	/**
	 * @param vy the vy to set
	 */
	public void setVy(double vy) {
		this.vy = vy;
	}

	/**
	 * @return the v
	 */
	public double getV() {
		return v;
	}

	/**
	 * @param v the v to set
	 */
	public void setV(double v) {
		this.v = v;
	}

	/**
	 * @return the yMax
	 */
	public int getyMax() {
		return yMax;
	}

	/**
	 * @param yMax the yMax to set
	 */
	public void setyMax(int yMax) {
		this.yMax = yMax;
	}
	
	
	
	
}
