/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3ï¿½ de Ingieneria Informï¿½tica
 * 	Fecha: 18-04-2017
 * 	Programa principal de nuestra simulacion de camino aleatorio
 * @author: Alejandro Hernandez Padron
 *
 */

package camino_aleatorio;

import java.awt.BorderLayout;

import javax.swing.JFrame;


/**
 * Clase principal de nuestro programa
 * El cual añade todos los elementos a un frame en inicia nuestro
 * controlador vistas y modelo
 */
public class ProgramCamino extends JFrame{

	private static final long serialVersionUID = 1L;
	private CaminoView vistaCamino;						//Vista de nuestro camino
	private PanelView vistaButtons;						//Vista de los botones
	private CaminoControl control;						//Controlador del programa
	
	/**
	 * Main del programa
	 * @param args
	 */
	public static void main(String[] args) {
		ProgramCamino pr = new ProgramCamino();
	}

	/**
	 * Contructor por defecto de nuestro aplicaion
	 */
	ProgramCamino (){
		
		setVistaCamino(new CaminoView());	//Inicia las vistas
		setVistaButtons(new PanelView());
		
		//Inicia el controlador
		setControl(new CaminoControl(getVistaCamino(), getVistaButtons(), new Camino(50, 50)));
		
		//Añadimos el controlador a nuestras vistas
		getVistaCamino().setControl(getControl());
		getVistaButtons().setControl(getControl());
		
		setLayout(new BorderLayout());		//Añadimos las vistas a nuestro frame
		add(getVistaButtons(), BorderLayout.EAST);
		add(getVistaCamino(), BorderLayout.CENTER);
		
		
		setTitle("Camino Aleatorio");		//Nombre del programa
		setLocation(300, 100); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setVisible(true);
	}


	/**
	 * @return the vistaCamino
	 */
	public CaminoView getVistaCamino() {
		return vistaCamino;
	}


	/**
	 * @param vistaCamino the vistaCamino to set
	 */
	public void setVistaCamino(CaminoView vistaCamino) {
		this.vistaCamino = vistaCamino;
	}


	/**
	 * @return the vistaButtons
	 */
	public PanelView getVistaButtons() {
		return vistaButtons;
	}


	/**
	 * @param vistaButtons the vistaButtons to set
	 */
	public void setVistaButtons(PanelView vistaButtons) {
		this.vistaButtons = vistaButtons;
	}


	/**
	 * @return the control
	 */
	public CaminoControl getControl() {
		return control;
	}


	/**
	 * @param control the control to set
	 */
	public void setControl(CaminoControl control) {
		this.control = control;
	}
	
	
}
