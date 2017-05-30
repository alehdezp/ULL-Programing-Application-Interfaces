/**
s * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informï¿½tica
 * 	Fecha: 4-05-2017
 * 	Vista del Panel de informacion de nuestro tiro
 * @author: Alejandro Hernandez Padron
 *
 */

package parabolico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DibujaTiro extends JPanel{
	private ControlTiro control; //Controlado de nuestro modelo
	private VistaPanel panelInfo;	//Panel de informacion

	private int ejeY;		//Longitud de los ejes
	private int ejeX;		
	private Boolean rastro = true;	 //Dibujamos rastro de la bola
	
	//PUntos con los rastros de nuestra bola
	private ArrayList<ArrayList<Integer>> ys = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> xs = new ArrayList<>();
	private int xA = 0 ;	//x e y actual
	private int yA = 0;
	private int fLong = 50;		//Longitud flecha
	private int angulo = 45;	//angulo inicial
	private ArrayList<Color> rastroColor = new ArrayList<>();

	/**
	 * Constructor por defecto
	 */
	public DibujaTiro() {
		getXs().add(new ArrayList<Integer>());
		getYs().add(new ArrayList<Integer>());
		addColor();
	}

	/**
	 * Metodo paintComponent que dibuja nuestro modelo y los ejes
	 * el Angulo y el panel de informacion
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);

		paintEjes(g);
		dibujaAngulo(g);
		dibujaTiro(g);
		getPanelInfo().dibujaPanel(g, getWidth(), getHeight());
		
	}

	/**
	 * Dibujamos el tiro  y su rastro a partir del numero de tiros
	 * y el proyectil actual x e y 
	 * @param g
	 */
	public void dibujaTiro(Graphics g){
		g.setColor(rastroColor.get(rastroColor.size()-1));
		g.fillOval(xA + 30, getHeight() - 50 - yA, 20, 20);
		for (int j = 0; j < xs.size(); j++) {
			g.setColor(rastroColor.get(j));
			if(rastro)						//Si rastro == true, dibujamos el rastro
				for (int i = 0; i < xs.get(j).size() - 1; i++) {
					if(i % 8 == 0)
						g.fillOval(xs.get(j).get(i) + 43, getHeight() - 43 - ys.get(j).get(i), 6, 6);
				}
		}
	}

	/**
	 * Dibujamos los ejes a una distancia de 40 del borde
	 * de la izquierda y el de la derecha
	 * cada 10 unidades dibujamos una raya perpendicular
	 * a nuestros ejes y cada 50 dibujamos un string con la 
	 * cuenta de unidades
	 * @param g
	 */
	public void paintEjes(Graphics g){

		g.drawLine(40, 10, 40, getHeight() - 40);
		g.drawString(0 + "", 30, getHeight() - 35);
		int c= 1;
		for (int i = getHeight() - 50; i > 10; i= i-10) {
			if(c % 5 == 0){
				g.drawString((c*10) + "", 5, i + 5);
				g.setColor(Color.RED);
			}
			c++;
			g.drawLine(40, i, 30, i);
			g.setColor(Color.BLACK);
		}
		g.drawLine(40, getHeight() - 40, getWidth()-10, getHeight() - 40);
		c= 1;
		for (int i = 50; i < getWidth()-10; i= i+10) {
			if(c % 5 == 0){
				g.drawString((c*10) + "", i - 10, getHeight() - 15);
				g.setColor(Color.RED);
			}
			c++;
			g.drawLine(i, getHeight() - 40, i, getHeight() - 30);
			g.setColor(Color.BLACK);

		}
	}

	/**
	 * Dibujamos la flecha inicial de lanzamiento a partir del angulo inicial
	 * y su punta
	 * @param g
	 */
	public void dibujaAngulo(Graphics g){
		Graphics2D g2D=(Graphics2D)g;
		g2D.setStroke (new BasicStroke(1.5f));
		int auxX = (int) (fLong * Math.cos(Math.toRadians(angulo)) + 40);
		int auxY = (int) (fLong * Math.sin(Math.toRadians(angulo)) + 40);
		g2D.drawLine(40, getHeight() - 40, auxX, getHeight() - auxY);

		dibujaFlecha(g2D, 40, getHeight() - 40, auxX, getHeight() - auxY);
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
	 * Añadimos un nuevo color al modelo
	 */
	public void addColor(){
		Random rn = new Random();
		int c1 = rn.nextInt(255);
		int c2 = rn.nextInt(255);
		int c3 = rn.nextInt(255);
		rastroColor.add(new Color(c1, c2, c3));
	}
	
	
	
	/**
	 * @return the panelInfo
	 */
	public VistaPanel getPanelInfo() {
		return panelInfo;
	}

	/**
	 * @param panelInfo the panelInfo to set
	 */
	public void setPanelInfo(VistaPanel panelInfo) {
		this.panelInfo = panelInfo;
	}

	/**
	 * @return the rastroColor
	 */
	public ArrayList<Color> getRastroColor() {
		return rastroColor;
	}

	/**
	 * @param rastroColor the rastroColor to set
	 */
	public void setRastroColor(ArrayList<Color> rastroColor) {
		this.rastroColor = rastroColor;
	}

	/**
	 * @return the fLong
	 */
	public int getfLong() {
		return fLong;
	}

	/**
	 * @param fLong the fLong to set
	 */
	public void setfLong(int fLong) {
		this.fLong = fLong;
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
	 * @return the rastro
	 */
	public Boolean getRastro() {
		return rastro;
	}

	/**
	 * @param rastro the rastro to set
	 */
	public void setRastro(Boolean rastro) {
		this.rastro = rastro;
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
	 * @return the ys
	 */
	public ArrayList<ArrayList<Integer>> getYs() {
		return ys;
	}

	/**
	 * @param ys the ys to set
	 */
	public void setYs(ArrayList<ArrayList<Integer>> ys) {
		this.ys = ys;
	}

	/**
	 * @return the xs
	 */
	public ArrayList<ArrayList<Integer>> getXs() {
		return xs;
	}

	/**
	 * @param xs the xs to set
	 */
	public void setXs(ArrayList<ArrayList<Integer>> xs) {
		this.xs = xs;
	}

	/**
	 * @return the xA
	 */
	public int getxA() {
		return xA;
	}

	/**
	 * @param xA the xA to set
	 */
	public void setxA(int xA) {
		this.xA = xA;
	}

	/**
	 * @return the yA
	 */
	public int getyA() {
		return yA;
	}

	/**
	 * @param yA the yA to set
	 */
	public void setyA(int yA) {
		this.yA = yA;
	}

	/**
	 * @return the ejeY
	 */
	public int getEjeY() {
		return ejeY;
	}

	/**
	 * @param ejeY the ejeY to set
	 */
	public void setEjeY(int ejeY) {
		this.ejeY = ejeY;
	}

	/**
	 * @return the ejeX
	 */
	public int getEjeX() {
		return ejeX;
	}

	/**
	 * @param ejeX the ejeX to set
	 */
	public void setEjeX(int ejeX) {
		this.ejeX = ejeX;
	}


}
