package graficos;

import java.awt.GridLayout;

import javax.swing.JFrame;



public class DibujaFunciones extends JFrame{
	
	public DibujaFunciones (){
		setTitle("Funciones");
		setLayout(new GridLayout(1, 0, 5, 5));
		add(new Cuadratica());
		add(new Cubica());
	}
	
	public static void main(String[] args) {
	    DibujaFunciones frame = new DibujaFunciones();
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800, 400);
	    frame.setVisible(true);
	}
	
	
	
}
