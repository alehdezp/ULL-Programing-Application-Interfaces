package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Cara extends JPanel{
	
	
	
	Cara(){
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

	    int xCenter = getWidth() / 2;
	    int yCenter = getHeight() / 2;
	    int width = getWidth();
	    int height = getHeight();
	    
	    int radius = width / 2;
	    
	    g.drawOval((int)(xCenter - radius / 2), (int)(yCenter - radius / 2), (int)(radius), (int)(radius));
	    g.setColor(Color.RED);
	    g.drawLine((int)(xCenter - radius / 5), (int)(yCenter + radius / 5), (int)(xCenter + radius / 5), (int)(yCenter + radius / 5));
	    
	    g.setColor(Color.BLUE);
	    g.fillOval((int)(xCenter - radius / 4), (int)(yCenter - radius / 5), (int)(radius / 6), (int)(radius / 6));
	    g.fillOval((int)(xCenter + radius / 4 - radius/6), (int)(yCenter - radius / 5), (int)(radius / 6), (int)(radius / 6));

	}
	
}
