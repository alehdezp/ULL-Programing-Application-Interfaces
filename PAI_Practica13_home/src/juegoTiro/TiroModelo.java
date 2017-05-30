/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 4-05-2017
 * 	Juego de bolas de colores
 * @author: Alejandro Hernandez Padron
 *
 */
package juegoTiro;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Clase con el tiro de nuestra bola
 * Esta clase contiene el centro desde el que disparamos
 * con sus respectivos colores y calcula nuestro disparo
 * hasta que llegue a un extremo o impacte con otra bola
 */
public class TiroModelo {
	
	//Bola de disparo de de centro con sus colores
	private Ellipse2D tiro;
	private Ellipse2D centro;
	private Color colorTiro;
	private Color colorCentro;
	private Color[] colores = new Color[]{Color.BLUE, Color.GREEN,
			Color.MAGENTA, Color.RED, Color.ORANGE};
	
	//Alto y ancho del panel, y diametro de nuestra bola
	private int ancho, alto;	
	private int diametro;
	private int y; //posicion y
	private double y0 = 0; //posicion y inicial
	private double vy0; //velocidad y inicial;
	private int x;// posicion x;
	private double x0 = 0; //posicion x inicial;
	private double vx0; //velocidad x inicial ;

	private double velocidadInicial = 40;		
	private int angulo = 90;
	private double tiempo = 0;
	double incrementoTiempo = 0.10;

	/**
	 * Constructo del modelo
	 * setea el ancho alto y diametro de nuestra clase
	 * Calcula el centro y crea nuestras dos bolas con
	 * sus colores y nuestra velocidad 
	 * @param ancho
	 * @param alto
	 * @param diametro
	 */
	public TiroModelo(int ancho, int alto, int diametro){
		setDiametro(diametro);
		setAlto(alto);
		setAncho(ancho);
		setX0(ancho/2);			//Mitad del panel
		setY0(alto - diametro/2 -10);		//Parte inferior del panel

		setTiro(new Ellipse2D.Double(x0-diametro/2, y0-diametro/2, diametro, diametro));
		setCentro(tiro);
		colorTiro = randomColor();
		colorCentro = colorTiro;
		setVelocidadInicial(getVelocidadInicial());
	}

	/**
	 * Creamos un nuevo Centro cuando la bola sea disparada
	 */
	public void setNewBola(){
		colorCentro = randomColor();
		setCentro(new Ellipse2D.Double(x0-diametro/2, y0-diametro/2, diametro, diametro));
	}

	/**
	 * Metodo que va incrementando el tiempo de nuestra modelo
	 * actualiza la x y la y e a�ade los puntos en una matriz
	 * con todos los puntos calculados
	 */
	public void next(){

		tiempo += incrementoTiempo;
		x = (int) (vx0 * tiempo + x0 - diametro/2);
		y =  (int) (vy0 * tiempo + y0- diametro/2);
		tiro.setFrame(x, y, diametro, diametro);
	}

	/**
	 * Resetea el modelo a 0
	 */
	public void reset(){
		tiempo = 0;
		setTiro(this.centro);
		setColorTiro(this.colorCentro);

	}

	/**
	 * En funcion de a donde apunte nuestro raton 
	 * Calculamos el angulo que forma respecto de nuestro
	 * centro y reajustamos la velocdad en x y en y
	 * @param a
	 * @param b
	 */
	public void setAngulo(int a, int b){
		double m = (b-y0)/(a-x0);
		this.angulo = (int) Math.toDegrees(Math.atan(m));
		if(angulo >= 0){
			angulo = -180 + angulo;
		}
		vy0 = velocidadInicial * Math.sin(Math.toRadians(angulo));
		vx0 = velocidadInicial * Math.cos(Math.toRadians(angulo));
	}

	/**
	 * Metodo que conprueba que la bola no se ha salido del panel
	 * @return
	 */
	public Boolean isOut(){
		if(((x  + diametro) > (ancho)) || (x < 0) 
				|| (y < 0) || ((y  + diametro) > alto ))
			return true;

		return false;
	}

	/**
	 * Genera unn color random
	 * @return
	 */
	public Color randomColor(){
		Random rn = new Random();
		return colores[rn.nextInt(colores.length)];
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
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}


	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}


	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}


	/**
	 * @param colorCentro the colorCentro to set
	 */
	public void setColorCentro(Color colorCentro) {
		this.colorCentro = colorCentro;
	}


	/**
	 * @return the colores
	 */
	public Color[] getColores() {
		return colores;
	}


	/**
	 * @param colores the colores to set
	 */
	public void setColores(Color[] colores) {
		this.colores = colores;
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
	 * @return the incrementoTiempo
	 */
	public double getIncrementoTiempo() {
		return incrementoTiempo;
	}

	/**
	 * @param incrementoTiempo the incrementoTiempo to set
	 */
	public void setIncrementoTiempo(double incrementoTiempo) {
		this.incrementoTiempo = incrementoTiempo;
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


	/**
	 * @return the y0
	 */
	public double getY0() {
		return y0;
	}

	/**
	 * @param y0 the y0 to set
	 */
	public void setY0(double y0) {
		this.y0 = y0;
	}

	/**
	 * @return the vy0
	 */
	public double getVy0() {
		return vy0;
	}

	/**
	 * @param vy0 the vy0 to set
	 */
	public void setVy0(double vy0) {
		this.vy0 = vy0;
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
	 * @return the x0
	 */
	public double getX0() {
		return x0;
	}

	/**
	 * @param x0 the x0 to set
	 */
	public void setX0(double x0) {
		this.x0 = x0;
	}

	/**
	 * @return the vx0
	 */
	public double getVx0() {
		return vx0;
	}

	/**
	 * @param vx0 the vx0 to set
	 */
	public void setVx0(double vx0) {
		this.vx0 = vx0;
	}

	/**
	 * @return the velocidadInicial
	 */
	public double getVelocidadInicial() {

		return velocidadInicial;
	}

	/**
	 * @param velocidadInicial the velocidadInicial to set
	 */
	public void setVelocidadInicial(double velocidadInicial) {
		vy0 = velocidadInicial * Math.sin(Math.toRadians(-angulo));
		vx0 = velocidadInicial * Math.cos(Math.toRadians(-angulo));

		this.velocidadInicial = velocidadInicial;
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


}
