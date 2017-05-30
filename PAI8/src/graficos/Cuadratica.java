package graficos;

import java.awt.Polygon;


class Cuadratica extends Funciones{
	private double factorDeEscala = 0.01;

	public Cuadratica (){
		super();
	}
	
	public double f (double x){
		return factorDeEscala * x * x;
	}
}
