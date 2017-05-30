package calculadora;

import java.util.Observable;


public class Model extends Observable{
	private float euro;	//primitive, automatically initialised to 0
	
	public Model(){

		System.out.println("Model()");
		setValue(0);

	} //Model()


	public float getValue(){return euro;}


	public void setValue(float value) {

		this.euro = value;
		
		setChanged();
		notifyObservers(getValue());

	} //setValue()
	
} //Model

