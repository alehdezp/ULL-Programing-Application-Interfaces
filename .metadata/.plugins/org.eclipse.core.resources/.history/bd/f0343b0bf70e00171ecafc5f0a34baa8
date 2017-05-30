package calculadora;


import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;	//for CloseListener()
import java.awt.event.WindowAdapter;	//for CloseListener()
import java.lang.Integer;		//int from Model is passed as an Integer
import java.util.Observable;		//for update();
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.TitledBorder;

class View extends JFrame implements Observer {
	
	private float euros;
	private JTextField euroDText;
	private JTextField euroLText;
	private JTextField euroRText;
						
	private static float dolarC = (float) 1.07;
	private JTextField dolarText;
	private static float libraC = (float) 0.86;
	private JTextField libraText;
	private static float rupiaC = (float) 70.63;
	private JTextField rupiaText;
	
	View() {
		
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));	
		
		JPanel principalView = new JPanel(new GridLayout(0, 1, 5, 5));
		JLabel msgEuro = new JLabel("1 Euro is "); 
		euroDText = new JTextField("1", 7);
		euroLText = new JTextField("1", 7);
		euroRText = new JTextField("1", 7);
		dolarText = new JTextField("" + dolarC, 7);
		libraText = new JTextField("" + libraC, 7);
		rupiaText = new JTextField("" + rupiaC, 7);
		JPanel dolarPanel = new JPanel(new GridLayout(3, 1, 0, 0));
		JPanel dolarF1 = new JPanel(new FlowLayout(0, 0, 0));	
		dolarF1.add(new JLabel("1 Euro is "));
		dolarF1.add(new JTextField(""+ dolarC));
		dolarF1.add(new JLabel("  Dolar	"));
		
		
		JPanel dolarF2 = new JPanel(new FlowLayout(0, 0, 0));
		dolarF2.add(new JLabel(" Euro                    Dolar"));
		
		JPanel dolarF3 = new JPanel(new FlowLayout(0, 0, 0));
		dolarF3.add(euroDText);
		dolarF3.add(dolarText);
		
		dolarPanel.add(dolarF1);
		dolarPanel.add(dolarF2);
		dolarPanel.add(dolarF3);
		
	    dolarPanel.setBorder(new TitledBorder("Dolar"));
		
		JPanel libraPanel = new JPanel(new GridLayout(3, 1, 0, 0));
		JPanel libraF1 = new JPanel(new FlowLayout(0, 0, 0));	
		libraF1.add(new JLabel("1 Euro is "));
		libraF1.add(new JTextField(""+ libraC));
		libraF1.add(new JLabel("  Libra	"));
		
		
		JPanel libraF2 = new JPanel(new FlowLayout(0, 0, 0));
		libraF2.add(new JLabel(" Euro                    Libra"));
		
		JPanel libraF3 = new JPanel(new FlowLayout(0, 0, 0));
		libraF3.add(euroLText);
		libraF3.add(libraText);
		
		libraPanel.add(libraF1);
		libraPanel.add(libraF2);
		libraPanel.add(libraF3);
		
	    libraPanel.setBorder(new TitledBorder("Libra"));
	    
	    JPanel rupiaPanel = new JPanel(new GridLayout(3, 1, 0, 0));
		JPanel rupiaF1 = new JPanel(new FlowLayout(0, 0, 0));	
		rupiaF1.add(new JLabel("1 Euro is "));
		rupiaF1.add(new JTextField(""+ rupiaC));
		rupiaF1.add(new JLabel("  rupia	"));
		
		
		JPanel rupiaF2 = new JPanel(new FlowLayout(0, 0, 0));
		rupiaF2.add(new JLabel(" Euro                    Rupia"));
		
		JPanel rupiaF3 = new JPanel(new FlowLayout(0, 0, 0));
		rupiaF3.add(euroRText);
		rupiaF3.add(rupiaText);
		
		rupiaPanel.add(rupiaF1);
		rupiaPanel.add(rupiaF2);
		rupiaPanel.add(rupiaF3);
		
	    rupiaPanel.setBorder(new TitledBorder("Rupia"));
	    
		
		
		principalView.add(dolarPanel);
		principalView.add(libraPanel);
		principalView.add(rupiaPanel);
		add("Center", principalView);
		
	
		
		setTitle("Calculadora.java");
		addWindowListener(new CloseListener());	
		setSize(200, 400);
		setLocation(1200,400);
		setVisible(true);

	} //View()

	public void update(Observable obs, Object obj) {
		setEuros(((Float)obj).intValue());
		System.out.println("updating");
		euroDText.setText("" + getEuros());
		euroLText.setText("" + getEuros());
		euroRText.setText("" + getEuros());
		dolarText.setText("" + (getEuros() * dolarC));
		libraText.setText("" + (getEuros() * libraC));
		rupiaText.setText("" + (getEuros() * rupiaC));
		
	} //update()
	
	public void updateCalculator(){

		validate();
		repaint();
		setVisible(true);
	}

	/**
	 * @return the euros
	 */
	public float getEuros() {
		return euros;
	}

	/**
	 * @param euros the euros to set
	 */
	public void setEuros(float euros) {
		this.euros = euros;
	}


	public void addController(Controller controller){
		
	} //addController()
		
	public static class CloseListener extends WindowAdapter {

		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} //windowClosing()
	} //CloseListener

} //View

