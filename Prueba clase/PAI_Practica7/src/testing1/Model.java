package testing1;
import java.util.Observable;

public class Model extends Observable{
	private int counter;	//primitive, automatically initialised to 0
	private String output;
	
	public Model(){

		System.out.println("Model()");
		setValue(0);

	} //Model()


	public int getValue(){return counter;}


	public void setValue(int value) {

		this.counter = value;
		System.out.println("Model init: counter = " + counter);
		
		setChanged();
		notifyObservers(counter);

	} //setValue()
	
	public void incrementValue() {

		++counter;
		System.out.println("Model     : counter = " + counter);
	
		setChanged();
		//model Push - send counter as part of the message
		notifyObservers(getValue());

	} //incrementValue()

	public String getOutput() {
		String aux = output;
		output = "";
		return aux;
	}




	
} //Model

