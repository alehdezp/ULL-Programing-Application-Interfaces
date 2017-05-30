/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informï¿½tica
 * 	Fecha: 4-05-2017
 * 	Juego de bolas de colores
 * @author: Alejandro Hernandez Padron
 *
 */
package juegoTiro;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Clase con el boton y el panel de informacion
 */
public class InfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Controlador control;
	JButton info;
	JOptionPane jp = new JOptionPane("Informacion");


	InfoPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		ImageIcon fot = new ImageIcon("info.jpg");

		Icon i = new ImageIcon(fot.getImage().getScaledInstance(20, 20, 5));
		info = new JButton(i);
		add(info);
	}

	/**
	 * mostramos nuestro panel de informacion
	 */
	public void showinfo(){
		JOptionPane.showMessageDialog(null, "Bienvenido al juego de las Bolas\n"
				+ "El juego es muy sencillo dispara las bolas de la parte inferior para\n eliminar to "
				+"las bolas del parte superior \n\n Autor:Alejandro Hdez Padrón ");
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
		getInfo().setName("Info");
		getInfo().setActionCommand("Info");
		getInfo().addActionListener(control);
		this.control = control;
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
	 * @return the jp
	 */
	public JOptionPane getJp() {
		return jp;
	}

	/**
	 * @param jp the jp to set
	 */
	public void setJp(JOptionPane jp) {
		this.jp = jp;
	}




}
