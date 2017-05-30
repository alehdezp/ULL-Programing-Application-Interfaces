/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 4-05-2017
 * 	Juego de bolas de colores
 * @author: Alejandro Hernandez Padron
 *
 */
package juegoTiro;

import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * Clase Contructora de nuestro juego, inica modelo controlador
 * y vista
 */
public class Disparos extends JApplet{
	private Controlador control;
	private VistaJuego vista;
	private InfoPanel info;
	private int width = 1000;
	private int height = 800;
	private int nBolas = 7;
	private int diametro = 60;
	private JFrame fr;
	
	public Disparos() {
		setVista(new VistaJuego());
		setInfo(new InfoPanel());
		setLayout(new BorderLayout());
		add(getVista(), BorderLayout.CENTER);
		add(getInfo(), BorderLayout.SOUTH);
		setControl(new Controlador(getVista(), getInfo(), diametro));
		fr = new JFrame("Juego de bolas");
		fr.add(this);
		fr.setTitle("applet");		//Nombre del programa
		fr.setLocation(300, 100); // Center the frame
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(width, height);
		fr.setVisible(true);
		getControl().setModelo();
		 }
	
	public static void main(String[] args) {
		Disparos dis = new Disparos();
	}
	
	
	/**
	 * @return the info
	 */
	public InfoPanel getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(InfoPanel info) {
		this.info = info;
	}

	/**
	 * @return the nBolas
	 */
	public int getnBolas() {
		return nBolas;
	}

	/**
	 * @param nBolas the nBolas to set
	 */
	public void setnBolas(int nBolas) {
		this.nBolas = nBolas;
	}

	/**
	 * @return the diametro
	 */
	public int getDiametro() {
		return diametro;
	}

	/**
	 * @param diametro the diametro to set
	 */
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the fr
	 */
	public JFrame getFr() {
		return fr;
	}

	/**
	 * @param fr the fr to set
	 */
	public void setFr(JFrame fr) {
		this.fr = fr;
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

	/**
	 * @return the vista
	 */
	public VistaJuego getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(VistaJuego vista) {
		this.vista = vista;
	}
	
	
}
