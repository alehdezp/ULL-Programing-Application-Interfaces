package parabolico;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaInfo extends JFrame{
	public VistaInfo(){
		setLayout(new FlowLayout(5));

		JPanel grid1 =  new JPanel(new GridLayout(0, 1));
		JPanel flow1 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow2 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow3 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow4 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow5 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow6 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		flow1.add(new JLabel("Asignatura: Programacion de aplicaciones interactivas"));
		flow2.add(new JLabel("Universidad de La Laguna Grado de Ingieria informática ULL"));
		flow3.add(new JLabel("Alumno: Alejandro Hdez Padron, alu0100891836"));
		flow4.add(new JLabel("Esta aplicacion simula el lanzamiento de un proyectil y dibuja su \n"
				+ "trayectoria, se puede modificar su angulo de lanzamiento y su velocidad"));
		flow5.add(new JLabel("y dibuja su trayectoria. se puede modificar su angulo de lanzamiento y su velocidad"));
		flow6.add(new JLabel("Se puede modificar su angulo de lanzamiento y su velocidad"));
		add(flow1);
		add(flow2);
		add(flow3);
		add(flow4);
		add(flow5);
		add(flow6);
		setLocation(100, 100); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
		setVisible(true);
		
	}
}
