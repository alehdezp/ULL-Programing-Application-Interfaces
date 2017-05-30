package calculadora;



import  java.awt.event.ActionListener;

import javax.management.modelmbean.ModelMBean;

import java.awt.event.ActionEvent;

class Controller implements ActionListener {

	Model model;
	View view;

	Controller() {	
		System.out.println ("Controller()");
	} //Controller()

	public void actionPerformed(ActionEvent e){
		
		System.out.println("Controller: acting on Model");
		//this.view.update(model, model.getValue());
		
	} //actionPerformed()

	
	public void addModel(Model m){
		System.out.println("Controller: adding model");
		this.model = m;
	} //addModel()

	public void addView(View v){
		System.out.println("Controller: adding view");
		this.view = v;
	} //addView()

	public void setModel(float x){
		model.setValue(x);

	} //initModel()

} //Controller
