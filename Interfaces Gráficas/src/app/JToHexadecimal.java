package app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class JToHexadecimal extends JFrame{
	JPanel panelDinamic;
	JTextField text;
	
		public JToHexadecimal (int dec){

		setLayout(new GridLayout(3, 1, -5, 0));			//GridLayout con 4  filas

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));	//JPanel con FlowLayout
		JLabel welcome = new JLabel("Convertidor a hexadecimal");	//JLabel

		Font largeFont = new Font("Serif", Font.BOLD, 20);		//Fuente
		Border lineBorder = new LineBorder(Color.RED, 1);		//Marco del mensaje
		welcome.setFont(largeFont);
		welcome.setBorder(lineBorder);
		p1.add(welcome);			//añadimos al panel
		
		JPanel panelDinamic = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); 	//JPanel 2
		text = new JTextField(6);
		panelDinamic.add(new JLabel("Numero Hexadecimal: "));
		panelDinamic.add(new JTextField(6));
		panelDinamic.add(new JLabel("Numero Decimal: "));
		panelDinamic.add(text);
		JButton button = new JButton();	//Creamos un boton con un imagen
		try {
			Image img = ImageIO.read(getClass().getResource("examples/ok.png"));
			Image newimg = img.getScaledInstance( 27, 27,  java.awt.Image.SCALE_SMOOTH);
			button.setIcon(new ImageIcon(newimg));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		button.setCursor(new Cursor(Cursor.HAND_CURSOR));	//Modificamos el cursor encima del boton
		panelDinamic.add(button);
		
		add(p1);		//Añadimos lso paneles
		add(panelDinamic);	
		

		setTitle("JToHexadecimal.java");	//titulo
		setSize(500, 400);					//tamaño ventana
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Añadimos el número en decima calculado a la ventana
	 * @param dec
	 */
	public void actualiza(int dec){
		text.setText(" " + dec + "  ");
		validate();
		repaint();
		setVisible(true);
	}


}
