package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CaraDibujable extends JPanel{

	private int x, y, radius;
	private Cara face;

	Boolean manual = false;
	private Color color = Color.BLUE;

	public CaraDibujable(){
		setX(0);
		setY(0);

	}
	public CaraDibujable(String x, String y){
		setX(Integer.parseInt(x));
		setY(Integer.parseInt(y));
		setManual(true);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		setRadius(width /2);
		int xCenter = getCenterX(getManual()) + radius/2;
		int yCenter = getCenterY(getManual())+ getRadius()/2;
		setFace(new Cara(xCenter, yCenter, getRadius()));

		if(getManual()){
			g.drawOval((int)(getFace().getCaraX()), (int)(getFace().getCaraY()), (int)(getFace().getRadius()), (int)(getFace().getRadius()));
			g.setColor(Color.RED);
			g.drawLine((int)(getFace().getBocaX()), (int)(getFace().getBocaY()), (int)(getFace().getBocaX2()), (int)(getFace().getBocaY2()));

			g.setColor(Color.BLUE);
			g.fillOval((int)(getFace().getOjo1X()), (int)(getFace().getOjo1Y()), (int)(getFace().getOjoAlto()), (int)(getFace().getOjoAncho()));
			g.fillOval((int)(getFace().getOjo2X()), (int)(getFace().getOjo2Y()), (int)(getFace().getOjoAlto()), (int)(getFace().getOjoAncho()));
			
		}
		
//		else{
//			int xCenter = getCenterX(getManual());
//			int yCenter = getCenterY(getManual());
//			g.drawOval((int)(xCenter - radius / 2), (int)(yCenter - radius / 2), (int)(radius), (int)(radius));
//			g.setColor(Color.RED);
//			g.drawLine((int)(xCenter - radius / 5), (int)(yCenter + radius / 5), (int)(xCenter + radius / 5), (int)(yCenter + radius / 5));
//
//			g.setColor(Color.BLUE);
//			g.fillOval((int)(xCenter - radius / 4), (int)(yCenter - radius / 5), (int)(radius / 6), (int)(radius / 6));
//			g.fillOval((int)(xCenter + radius / 4 - radius/6), (int)(yCenter - radius / 5), (int)(radius / 6), (int)(radius / 6));
//
//		}
		

	}
	
	/**
	 * @return the face
	 */
	public Cara getFace() {
		return face;
	}
	/**
	 * @param face the face to set
	 */
	public void setFace(Cara face) {
		this.face = face;
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
	  * @return the manual
	  */
	 public Boolean getManual() {
		 return manual;
	 }
	 /**
	  * @param manual the manual to set
	  */
	 public void setManual(Boolean manual) {
		 this.manual = manual;
	 }
	 
		public int getCenterX(Boolean b){
			if(getManual())
				return getX();

			else
				return getWidth()/2;		
		}
		
		public int getCenterY(Boolean b){
			if(getManual())
				return getY();

			else
				return getHeight()/2;		
		}
}
