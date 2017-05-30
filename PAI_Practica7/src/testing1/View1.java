package testing1;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;	//for CloseListener()
import java.awt.event.WindowAdapter;	//for CloseListener()
import java.lang.Integer;		//int from Model is passed as an Integer
import java.util.Observable;		//for update();
import java.util.Observer;

import javax.swing.*;
import javax.swing.JPanel;

class View1 extends JFrame implements Observer {

	private JTextField myCounterField;
	private JPanel consolePanel;
	private JButton button; 
	
	private Model model;

	View1() {

		System.out.println("View()");	

		
	//	frame.setLayout(new GridLayout(0, 1, 0, 0));	
		
		JPanel counterView = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		
		counterView.add(new JLabel("counter: "));
		myCounterField = new JTextField("0", 3);
		counterView.add(myCounterField);
		add("North", counterView);

		JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		consolePanel = new JPanel(new GridLayout(0, 1, 0, 0));
		consolePanel.add(new JLabel("Console output	 $ "));
		consolePanel.add(new JLabel("View()"));
		flowPanel.add(consolePanel);
		
		
		add("Center", flowPanel);
		

		JPanel buttonPanel = new JPanel();
		button		= new JButton("PressMe");
		buttonPanel.add(button);
		add("South", buttonPanel);		
		
		setTitle("Counter.java");
		addWindowListener(new CloseListener());	
		setSize(400, 400);
		setLocation(1200,400);
		setVisible(true);

	} //View()

	public void update(Observable obs, Object obj) {
		setValue("" + ((Integer)obj).intValue());
		updateConsole("Model	: counter = " + ((Integer)obj).intValue());
	} //update()
	
	public void updateConsole(String line){
		consolePanel.add(new JLabel(line));
		validate();
		repaint();
		setVisible(true);
	}

	public void setValue(String v){

		myCounterField.setText("" + v);
	} //setValue()

	public void addController(Controller controller){

		System.out.println("View      : adding controller");
		button.addActionListener(controller);	//need controller before adding it as a listener 
	} //addController()
	
	public void addModel(Model m){
		System.out.println("View      : adding model");
		updateConsole("View		: adding model");
		this.model = m;
		
	} //addModel()
		
	public static class CloseListener extends WindowAdapter {

		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} //windowClosing()
	} //CloseListener

} //View
