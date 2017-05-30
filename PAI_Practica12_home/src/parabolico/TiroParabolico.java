/**
s * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informï¿½tica
 * 	Fecha: 4-05-2017
 * 	Vista del Panel de informacion de nuestro tiro
 * @author: Alejandro Hernandez Padron
 *
 */
package parabolico;

import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class TiroParabolico extends JApplet{
	ControlTiro control;
	DibujaTiro dibujo;
	VistaBotones botones;
	VistaPanel panelInfo;
	JFrame fr;
	
	/**
	 * Seteamos todos los elementos de vista modelo y controlador
	 * y añadimos los controladores a nuestras vistas
	 * Creamos un frame y añadimos nuestra applet con sus paneles
	 * añadidos
	 */
	public TiroParabolico(){
		setDibujo(new DibujaTiro());
		setBotones(new VistaBotones());
		setPanelInfo(new VistaPanel());
		setControl(new ControlTiro (new ModeloTiroParabolico(), getDibujo(), getBotones(), getPanelInfo()));
		getDibujo().setControl(getControl());
		getBotones().setControl(getControl());
		//getPanelInfo().setControl(getControl());
		setLayout(new BorderLayout());
		add(getBotones(), BorderLayout.SOUTH);
		add(getDibujo(),  BorderLayout.CENTER);
		fr = new JFrame("pruebas");
		fr.add(this);
		fr.setTitle("applet");		//Nombre del programa
		fr.setLocation(300, 100); // Center the frame
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(1000, 800);
		fr.setVisible(true);
	}
	
	public static void main(String[] args) {
		TiroParabolico tr = new TiroParabolico();
	}

	/**
	 * @return the control
	 */
	public ControlTiro getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(ControlTiro control) {
		this.control = control;
	}

	/**
	 * @return the dibujo
	 */
	public DibujaTiro getDibujo() {
		return dibujo;
	}

	/**
	 * @param dibujo the dibujo to set
	 */
	public void setDibujo(DibujaTiro dibujo) {
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
	 * @return the panelInfo
	 */
	public VistaPanel getPanelInfo() {
		return panelInfo;
	}

	/**
	 * @param panelInfo the panelInfo to set
	 */
	public void setPanelInfo(VistaPanel panelInfo) {
		this.panelInfo = panelInfo;
	}
	
	
}
