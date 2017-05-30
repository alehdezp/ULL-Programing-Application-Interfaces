package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Escalera extends JPanel{

	public Escalera(){

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();

		for (int i = 0; (i < width) && (i < height); i = i + 20) {
			g.drawRect(0, i, 20 + i, 20);
		}
		
		
	}

}