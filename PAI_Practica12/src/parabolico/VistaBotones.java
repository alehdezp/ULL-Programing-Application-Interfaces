/**
s * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 4-05-2017
 * 	Vista del Panel de informacion de nuestro tiro
 * @author: Alejandro Hernandez Padron
 *
 */
package parabolico;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaBotones extends JPanel{
	
	private ControlTiro control;		//Controlador de nuestro modelo
	private JButton lanzar = new JButton("Lanzar");
	private JButton parar= new JButton("Parar");
	private JButton borrar= new JButton("Borrar");
	ImageIcon infoIcon;
	private JButton info= new JButton(infoIcon);
	private JCheckBox rastro = new JCheckBox("Dibujar rastro");
	private JTextField velocidad = new JTextField("50", 6);
	private JTextField angulo = new JTextField("45", 6);
	private JTextField roce = new JTextField("0.0", 6);
	
	/**
	 * Contstructor por defecto
	 */
	public VistaBotones(){
		setLayout(new GridLayout(1, 3));	
		setButtons();
		addButtons();
	}

	/**
	 * Metodo que a�ade todos los botones a nuestro obejeto
	 */
	private void addButtons(){
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		JPanel flow1 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow2 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow3 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		flow1.add(getLanzar());
		flow2.add(getParar());
		flow3.add(getBorrar());
		buttonPanel.add(flow1);
		buttonPanel.add(flow2);
		buttonPanel.add(flow3);
		add(buttonPanel);
		JPanel textPanel = new JPanel(new GridLayout(2, 1));
		JPanel flow4 =  new JPanel(new GridLayout(0, 1));
		JPanel flow5 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow6 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel flow7 =  new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		flow4.add(new JLabel("Velocidad: "));
		flow4.add(getVelocidad());
		
		flow5.add(new JLabel("Angulo: "));
		flow5.add(getAngulo());
		
		flow6.add(getRastro());
		
		setInfo(new JButton());
		getInfo().setIcon(new ImageIcon("icono/icono.jpg"));
		getInfo().setSize(5, 5);
		flow7.add(getInfo());
		flow4.add(new JLabel("Rozamiento: "));
		flow4.add(getRoce());
		
		textPanel.add(flow4);
		textPanel.add(flow5);
		textPanel.add(flow6);
		textPanel.add(flow7);
		setInfoIcon(new ImageIcon("icono/icono.jpg"));

		add(textPanel);
		
	}
	
	/**
	 * Metodo que setea los botones con las se�ales y su accion
	 */
	private void setButtons(){
		
		getLanzar().setName("Lanzar");
		getLanzar().setActionCommand("Lanzar");
		getLanzar().addActionListener(getControl());
		
		getParar().setName("Parar");
		getParar().setActionCommand("Parar");
		getParar().addActionListener(getControl());

		getBorrar().setName("Borrar");
		getBorrar().setActionCommand("Borrar");
		getBorrar().addActionListener(getControl());
		
		getAngulo().setName("Angulo");
		getAngulo().setActionCommand("Angulo");
		getAngulo().addActionListener(getControl());
		
		getVelocidad().setName("Velocidad");
		getVelocidad().setActionCommand("Velocidad");
		getVelocidad().addActionListener(getControl());
		
		getRastro().setName("Rastro");
		getRastro().setActionCommand("Rastro");
		getRastro().addActionListener(getControl());
		getRastro().setSelected(true);
		
		
		getInfo().setName("Info");
		getInfo().setActionCommand("Info");
		getInfo().addActionListener(getControl());
		
		getRoce().setName("Roce");
		getRoce().setActionCommand("Roce");
		getRoce().addActionListener(getControl());

	}

	
	/**
	 * @return the roce
	 */
	public JTextField getRoce() {
		return roce;
	}

	/**
	 * @param roce the roce to set
	 */
	public void setRoce(JTextField roce) {
		this.roce = roce;
	}

	/**
	 * @return the infoIcon
	 */
	public ImageIcon getInfoIcon() {
		return infoIcon;
	}

	/**
	 * @param infoIcon the infoIcon to set
	 */
	public void setInfoIcon(ImageIcon infoIcon) {
		this.infoIcon = infoIcon;
	}

	/**
	 * @return the info
	 */
	public JButton getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(JButton info) {
		this.info = info;
	}

	/**
	 * @return the rastro
	 */
	public JCheckBox getRastro() {
		return rastro;
	}

	/**
	 * @param rastro the rastro to set
	 */
	public void setRastro(JCheckBox rastro) {
		this.rastro = rastro;
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
		setButtons();
	}

	/**
	 * @return the lanzar
	 */
	public JButton getLanzar() {
		return lanzar;
	}

	/**
	 * @param lanzar the lanzar to set
	 */
	public void setLanzar(JButton lanzar) {
		this.lanzar = lanzar;
	}

	/**
	 * @return the parar
	 */
	public JButton getParar() {
		return parar;
	}

	/**
	 * @param parar the parar to set
	 */
	public void setParar(JButton parar) {
		this.parar = parar;
	}

	/**
	 * @return the borrar
	 */
	public JButton getBorrar() {
		return borrar;
	}

	/**
	 * @param borrar the borrar to set
	 */
	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}

	/**
	 * @return the velocidad
	 */
	public JTextField getVelocidad() {
		return velocidad;
	}

	/**
	 * @param velocidad the velocidad to set
	 */
	public void setVelocidad(JTextField velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * @return the angulo
	 */
	public JTextField getAngulo() {
		return angulo;
	}

	/**
	 * @param angulo the angulo to set
	 */
	public void setAngulo(JTextField angulo) {
		this.angulo = angulo;
	}
	
	
}
