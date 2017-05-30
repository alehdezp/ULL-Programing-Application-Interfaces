package pi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class ProgramaAguja extends JFrame{
	private VistaDibujo dibujo;
	private VistaBotones botones;
	private Controlador control;
	
	public static void main(String[] args) {
		ProgramaAguja pr = new ProgramaAguja();
	}
	
	public ProgramaAguja() {
		setDibujo(new VistaDibujo());
		setBotones(new VistaBotones());
		setControl(new Controlador(getBotones(), getDibujo()));
		
		getDibujo().setControl(getControl());
		getBotones().setControl(getControl());
		
		setLayout(new BorderLayout(0, 0));		//BorderLayout
		add(getDibujo(), BorderLayout.CENTER);	//A�adimos nuestro frame con la bola
		add(getBotones(), BorderLayout.SOUTH);
		
		setTitle("Camino Aleatorio");		//Nombre del programa
		setLocation(300, 100); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
	}

	/**
	 * @return the dibujo
	 */
	public VistaDibujo getDibujo() {
		return dibujo;
	}

	/**
	 * @param dibujo the dibujo to set
	 */
	public void setDibujo(VistaDibujo dibujo) {
		this.dibujo = dibujo;
	}

	/**
	 * @return the botones
	 */
	public VistaBotones getBotones() {
		return botones;
	}

	/**
	 * @param botones the botones to set
	 */
	public void setBotones(VistaBotones botones) {
		this.botones = botones;
	}

	/**
	 * @return the control
	 */
	public Controlador getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(Controlador control) {
		this.control = control;
	}

	
}
