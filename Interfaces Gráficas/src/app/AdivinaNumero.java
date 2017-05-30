/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 14-02-2017
 * 	Programa de ejemplo de uso de JFrames y JPanel en java
 * 	Genera un n�mero aleatorio que el usuario tiene que adivinar
 * @author: Alejandro Hern�ndez Padr�n
 *
 */


package app;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;


public class AdivinaNumero {
	private int random;					//Guardamos el n�mero aleatorio generado
	
	/**
	 * Main principal de programa, incialiaza los objetos JFrame y Adivina Numero
	 * @param args
	 */
	public static void main(String[] args) {	
		JAdivinaNumero frame = new JAdivinaNumero();	//Inicializamos
		AdivinaNumero num = new AdivinaNumero();
		System.out.print("Bienvenido al juego, Adivina el Numero\n"
				+ "Introduzca un numero menor de tres cifras para "
				+ "obetener su premio:(" + num.getRandom() + ")");
		
		Scanner reader = new Scanner(System.in);		//Leemos por teclado el n�mero
		int number = reader.nextInt();					//usuario
		reader.close();									//cerramos el Scanner
		
		System.out.print(num.getResult(number));		//Imprimos el resultado en consola y en la 
		frame.resultado(num.getResult(number));			//ventana
		 
		
	}
	
	/**
	 * Contstructor por defecto de la clase
	 */
	public AdivinaNumero(){				
		setRandom();			//genera el n�mero aleatorio
	}
	
	/**
	 * Funci�n que nos devuelve el resultado de nuestro juego
	 * le pasamos el n�mero del usuario y lo comparamos con el 
	 * aleatorio
	 * @param n
	 * @return
	 */
	public String getResult(int n){
		int r1, r2, r3, n1, n2, n3;				//	ri = unidad del n�mero random
												//  ni = unidad n�mero usuario	
		
		r1 = getRandom() % 10;					//	unidad
		r2 = (getRandom() % 100 - r1) / 10;			//decenas
		r3 = (getRandom() % 1000 - r1 - r2) / 100;	//centenas

		n1 = n % 10;
		n2 = (n % 100 - n1) / 10;
		n3 = (n % 1000 - n1 - n2) / 100;

		if((r1 == n1) && (r2 == n2) && (r3 == n3))			//Calculo primer premio si todos son iguales
			return "HAS GANADO EL PRIMER PREMIO, 10.000�!!";
		if(((n1 == r1) || (n1 == r2) || (n1 == r3))			//Calculo segundo premio si son iguales
				&& ((n2 == r1) || (n2 == r2) || (n2 == r3))	//pero en disitinto orden
				&& ((n3 == r1) || (n3 == r2) || (n3 == r3)))
			return "HAS GANADO EL SEGUNDO PREMIO, 3.000�!!";
		if(((n1 == r1) || (n1 == r2) || (n1 == r3))			//Tercer premio, si al menos son dos iguales
				&& (((n2 == r1) || (n2 == r2) || (n2 == r3))
				|| ((n3 == r1) || (n3 == r2) || (n3 == r3))))
			return "HAS GANADO EL TERCER PREMIO, 2.000�!!";
		if(((n2 == r1) || (n2 == r2) || (n2 == r3))			//Tercer premio, si al menos son dos iguales
				&& (((n1 == r1) || (n1 == r2) || (n1 == r3))
				|| ((n3 == r1) || (n3 == r2) || (n3 == r3))))
			return "HAS GANADO EL TERCER PREMIO, 2.000�!!";
		if((n1 == r1) || (n1 == r2) || (n1 == r3)			//Caurto premio, si hay alguno igual
				|| (n2 == r1) || (n2 == r2) || (n2 == r3)
				|| (n3 == r1) || (n3 == r2) || (n3 == r3))
			return "HAS GANADO EL CUARTO PREMIO, 1.000�!!";
		return "HAS PERDIDO, JUEGA OTRA VEZ";
	}	
	
	/**
	 * Setter de random
	 * Generamos el n�mero aleatorio
	 */
	public void setRandom(){		
		Random rn = new Random();		
		random = rn.nextInt(1000);
	}
	
	/**
	 * Getter de random
	 * @return
	 */
	public int getRandom(){
		return this.random;
	}
	
	
}
