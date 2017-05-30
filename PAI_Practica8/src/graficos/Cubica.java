package graficos;

public class Cubica extends Funciones{
	private double factorDeEscala = 0.01;

	public Cubica (){
		super();
	}
	
	public double f (double x){
		return factorDeEscala * x * x * x;
	}
}
