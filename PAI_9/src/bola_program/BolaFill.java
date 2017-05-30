/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 4-03-2017
 * 	Clase que hereda de Figura y contiene los atributos y metodso
 * para dibujar la bola
 * @author: Alejandro Hern�ndez Padr�n
 *
 */

package bola_program;

import java.awt.Color;
import java.awt.Graphics;

public class BolaFill extends Figura{

	//Atributos 
	
	int radius;			//Radios de la bola
	int bolaCenterX;	//Centro de la bola
	int bolaCenterY;
	Boolean border = false;//Centro de la bola


	public BolaFill(Color color, int factor){
		super(factor);		//Llamamos a la clase padre con el factor
		setColor(color);	//Color de nuestra figura
	}


	public void setCenter(int x, int y, int radio){
		setCenterX(x);				//Centro de la ventana
		setCenterY(y);
		
		setMoveX(getMoveX());		//Actualizamos el desplazamiento
		setMoveY(getMoveY());
		
		setBolaCenterX(x - radio/2 + getMoveX());	//Seteamos el centro de la bola y su radio
		setBolaCenterY(y - radio/2 + getMoveY());
		setRadius(radio/2);
	}
	
	/**
	 * Metodo que dibuja nuestra bola
	 */
	public void paint(Graphics g){	
		g.setColor(getColor());		//Dibujamos segun el color
									//Dibujamos nuestra bola 
		g.fillOval(getBolaCenterX(), getBolaCenterY(), getRadius() * 2, getRadius() * 2);
		
	}
	
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * Desplaza el objeto siempre que no se salga de los limites de la ventana
	 * @param moveY
	 */
	public void setMoveY(int moveY) {
		int min = getRadius() - getCenterY();
		int max = -getRadius() + getCenterY();
		setBorder(true);
		if (moveY <= min )
			super.setMoveY(min);
		else if (moveY >= max)
			super.setMoveY(max);
		else{
			setBorder(false);
			super.setMoveY(moveY);
		}				
	}

	/**
	 * Desplaza el objeto siempre que no se salga de los limites de la ventana
	 * @param moveX
	 */
	public void setMoveX(int moveX) {
		int min = getRadius() - getCenterX();
		int max = -getRadius() + getCenterX();
		setBorder(true);
		if (moveX <= min )
			super.setMoveX(min);
		else if (moveX >= max)
			super.setMoveX(max);
		else{
			setBorder(false);
			super.setMoveX(moveX);
		}	
	}
	
	
	/**
	 * @return the border
	 */
	public Boolean getBorder() {
		return border;
	}


	/**
	 * @param border the border to set
	 */
	public void setBorder(Boolean border) {
		this.border = border;
	}


	/**
	 * @return the bolaCenterX
	 */
	public int getBolaCenterX() {
		return bolaCenterX;
	}
	/**
	 * @param bolaCenterX the bolaCenterX to set
	 */
	public void setBolaCenterX(int bolaCenterX) {
		this.bolaCenterX = bolaCenterX;
	}
	/**
	 * @return the bolaCenterY
	 */
	public int getBolaCenterY() {
		return bolaCenterY;
	}
	/**
	 * @param bolaCenterY the bolaCenterY to set
	 */
	public void setBolaCenterY(int bolaCenterY) {
		this.bolaCenterY = bolaCenterY;
	}
	
	
}
