/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 4-03-2017
 * 	Panel que dibuja nuestra bola roja en nuestra ventana
 * @author: Alejandro Hern�ndez Padr�n
 *
 */


package bola_program;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Clase PanelDibujable la cual dibuja nuestra bola en un panel gr�fico 
 *
 */
public class PanelDibujable extends JPanel {

	//Atributos
	BolaFill bolaRoja;
	BolaFill bolaAzul;
	int factor;

	/**
	 * Contructor
	 * @param factor, es la unidad de desplazamiento en pixeles de nuestra bola
	 */
	public PanelDibujable(int factor){
		setFactor(factor);
		setBolaRoja(new BolaFill(Color.RED, factor));	//Construimos nuestra bola de color rojo
		setBolaAzul(new BolaFill(Color.BLUE, factor));
		getBolaRoja().setMoveX(-100);
		getBolaAzul().setMoveX(100);
	}
	
	/**
	 * Metodo paintComponent
	 * dibuja en nuestra de ventana la bola
	 */
	public void paintComponent(Graphics g){		
		super.paintComponent(g);
		
		int centerY = getHeight()/2;	//Centro de la ventana
		int centerX = getWidth()/2;		//Centro de la ventana
		int radio = 100;				//Radio del circulo;
		setBackground(Color.cyan);
		
		getBolaRoja().setCenter(centerX, centerY, radio);	//Colocamos su posicion
		getBolaAzul().setCenter(centerX, centerY, radio);
		
		getBolaRoja().paint(g);	
		getBolaAzul().paint(g);//pintamos nuestra bola
	}

	
	/**
	 * @return the bolaAzul
	 */
	public BolaFill getBolaAzul() {
		return bolaAzul;
	}

	/**
	 * @param bolaAzul the bolaAzul to set
	 */
	public void setBolaAzul(BolaFill bolaAzul) {
		this.bolaAzul = bolaAzul;
	}

	/**
	 * @return the bolaRoja
	 */
	public BolaFill getBolaRoja() {
		return bolaRoja;
	}

	/**
	 * @param bolaRoja the bolaRoja to set
	 */
	public void setBolaRoja(BolaFill bolaRoja) {
		this.bolaRoja = bolaRoja;
	}
	
	/**
	 * @return the factor
	 */
	public int getFactor() {
		return factor;
	}

	/**
	 * @param factor the factor to set
	 */
	public void setFactor(int factor) {
		this.factor = factor;
	}


}
