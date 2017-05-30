package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

abstract class Funciones extends JPanel{

	private Polygon pol = new Polygon();;

	public Funciones (){
		//dibujaFuncion();
	}	 	

	public abstract double f (double x);
	
	public void dibujaFuncion(){
	    int xCenter = getWidth() / 2;
	    int yCenter = getHeight() / 2;
		for (int x = -xCenter; x < xCenter; x++) {
			pol.addPoint(x + xCenter, yCenter - (int)f(x));
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.WHITE);
		
	    int xCenter = getWidth() / 2;
	    int yCenter = getHeight() / 2;
	    int width = getWidth();
	    int height = getHeight();
	    g.drawLine(0, yCenter, width, yCenter);
	    g.drawLine(xCenter, 0, xCenter, height);
	    
	    dibujaFuncion();

	    g.drawPolygon(pol);
	}
		
	
	
	
}
