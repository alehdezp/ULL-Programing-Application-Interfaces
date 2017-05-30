/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informática
 * 	Fecha: 14-02-2017
 * 	Programa de ejemplo de uso de JFrames y JPanel en java
 * 	Suma de dos número y maneja las posible excepciones que 
 * 	ocurran
 * @author: Alejandro Hernández Padrón
 *
 */

package app;

import java.util.Scanner;



public class Suma {
	private int op1, op2;		//Operandos de la suma


	/**
	 * Main de programa instancia los objetos
	 * @param args
	 */
	public static void main(String[] args) {
		Suma sum = new Suma();
		JSuma frame = new JSuma();				//mostramos la ventana
		frame.muestraSuma(sum.realizaSuma());	//muestra el resultado por ventana	
												//y consola
	}
	
	/**
	 * Constructor por defecto
	 */
	public Suma(){
		
	}

	public int realizaSuma(){
		Scanner reader = new Scanner(System.in);
		Boolean fin = false;
		while(fin == false){
			System.out.println("Introduzca los dos operandos a sumar: ");
			
			try{
				System.out.print("op1-> ");
				String op1 = reader.nextLine();			//leemos los dos operanddo de teclado
				System.out.print("op2-> ");
				String op2 = reader.nextLine();
				if(!isNumeric(op1)){
					throw new Exception("operando numero 1");	//Lanzamos excepción si no es
				}else if(!isNumeric(op2)){						//numerico 1 o 2
					throw new Exception("operando numero 2");
				}			
				fin = true;
				setOp1(Integer.parseInt(op1));		//Convertimos a int los Strings
				setOp2(Integer.parseInt(op2));
				reader.close();
				
			}catch(Exception e){			//Capturamos la Exception y la imprimimos
				System.out.println("Ha introducido incorrectamente el " + e.getMessage()
						+ "\n Vuelva a introducir los operandos.");
			}
		}
		int sum = getOp1() + getOp2();			
		System.out.println("La suma es igual a " + sum);
		return sum;											//Devolvemos la suma
	}
	
	/**
	 * @return the op1
	 */
	public int getOp1() {
		return op1;
	}

	/**
	 * @param op1 the op1 to set
	 */
	public void setOp1(int op1) {
		this.op1 = op1;
	}

	/**
	 * @return the op2
	 */
	public int getOp2() {
		return op2;
	}

	/**
	 * @param op2 the op2 to set
	 */
	public void setOp2(int op2) {
		this.op2 = op2;
	}

	/**
	 * Devuelve si la cadena es un entero
	 * @param cadena
	 * @return
	 */
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;	
		}
	}

}
