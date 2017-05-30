/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3ï¿½ de Ingieneria Informï¿½tica
 * 	Fecha: 18-04-2017
 * 	Vista de lso botones
 * @author: Alejandro Hernandez Padron
 *
 */

package camino_aleatorio;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *	Clase con los botones de nuestro porgrama 
 *
 */
public class PanelView extends JPanel{

	private static final long serialVersionUID = 823677675620416067L;
	
	private JButton empezar = new JButton("Empezar");	//boton empezar
	private JButton finalizar = new JButton("Finalizar"); //boton finalizar
	private JButton color= new JButton("Color");		//boton color
	private JTextField densidad = new JTextField(7);	//boton TextFiel con la densidad
	private CaminoControl control;						//Controlador de la vista
	
	/**
	 * Constructor por defecto 
	 */
	public PanelView() { 		//Añadimos los botones a nuestro panel
		setLayout(new FlowLayout(10, 10, 0));
		
		JPanel grid = new JPanel(new GridLayout(0, 1, 10, 10));
		
		JPanel emp = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
		emp.add(getEmpezar());
		grid.add(emp);
		JPanel fin = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
		fin.add(getFinalizar());
		grid.add(fin);
		JPanel color = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
		color.add(getColor());
		grid.add(color);
		JPanel dens = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
		dens.add(new JLabel("Densidad de la cuadricula"));
		dens.add(getDensidad());
		grid.add(dens);
		
		
		add(grid);  //Añadimos nuestro grid con los botones al panel
		
	}

	/**
	 * 
	 */
	public void setSignals(){
		System.out.println("setting listener");
		getEmpezar().setActionCommand("empezar");
		getEmpezar().addActionListener(getControl());
		
		getFinalizar().setActionCommand("finalizar");
		getFinalizar().addActionListener(getControl());
		
		getColor().setActionCommand("color");
		getColor().addActionListener(getControl());
		
		getDensidad().setActionCommand("densidad");		
		getDensidad().addActionListener(getControl());
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
		setSignals();
	}



	/**
	 * @return the empezar
	 */
	public JButton getEmpezar() {
		return empezar;
	}


	/**
	 * @param empezar the empezar to set
	 */
	public void setEmpezar(JButton empezar) {
		this.empezar = empezar;
	}


	/**
	 * @return the finalizar
	 */
	public JButton getFinalizar() {
		return finalizar;
	}


	/**
	 * @param finalizar the finalizar to set
	 */
	public void setFinalizar(JButton finalizar) {
		this.finalizar = finalizar;
	}


	/**
	 * @return the color
	 */
	public JButton getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(JButton color) {
		this.color = color;
	}


	/**
	 * @return the densidad
	 */
	public JTextField getDensidad() {
		return densidad;
	}


	/**
	 * @param densidad the densidad to set
	 */
	public void setDensidad(JTextField densidad) {
		this.densidad = densidad;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
