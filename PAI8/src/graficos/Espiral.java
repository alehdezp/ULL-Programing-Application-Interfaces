package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Espiral extends JPanel{



	public Espiral(){

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();
		int x = 0;
		int y = 10;
		int x2 = width - 10;
		int y2 = 0;

		g.drawLine(x, y , x2, y);
		Boolean alterna = true;
		width -= 10;
		for (int i = width - 10; i > 0; i -= 10) {
			if(alterna == true){
				alterna = false;
				y2 = y + i;
				x = x2 - i;
				g.drawLine(x2, y , x2, y2);
				g.drawLine(x2, y2 , x, y2);
			}else{
				alterna = true;
				y = y2 - i;
				x2 = x + i;
				g.drawLine(x, y2 , x, y);
				g.drawLine(x, y , x2, y);
			}


		}

	}


}
