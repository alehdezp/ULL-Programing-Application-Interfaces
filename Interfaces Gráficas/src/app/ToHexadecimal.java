/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informática
 * 	Fecha: 14-02-2017
 * 	Programa de ejemplo de uso de JFrames y JPanel en java
 * 	Convierte un numero hexadecimal en decimal
 * @author: Alejandro Hernández Padrón
 *
 */

package app;

import java.util.Scanner;

public class ToHexadecimal {
	
	private static String hexChar = "0123456789ABCDEF"; //caracteres hexadecimales
	
	/**
	 * Main de programa que captura las excepciones lanzadas por el mismo
	 * @param args
	 */
	public static void main(String[] args) {
		ToHexadecimal hex = new ToHexadecimal();
		try {
			hex.start();
		} catch (HexFormatException e) {
			
		}
	}
	
	/**
	 * contructor vacio por defecto
	 */
	public ToHexadecimal() {}
	
	/**
	 * Metodo que ejecuta el programa
	 * @throws HexFormatException
	 */
	public void start() throws HexFormatException{
		
		Boolean fin = false;
		Scanner reader = new Scanner(System.in);
		JToHexadecimal frame = new JToHexadecimal(0);		//Mostramos la ventana
		
		while (fin == false){		//mientras fin sea false
			
			System.out.print("Introduzca un número en hexadecimal para convertir: ");
			String hex = reader.nextLine();
			int dec;
			
			try {	//bloque try
				
				dec = hex2Decimal(hex);		//convertimos a hexadecimal
				
				System.out.println("El número " + hex + " convertido a "
						+ "decimal es "+ dec);
				
				frame.actualiza(dec);		//actualizamos la ventana con el resultado de la operación
				
			} catch (HexFormatException e) {	//Capturamos la excepcion HexFormatExceptio		
				System.out.println(e);
			}
			
			System.out.println("Desea introducir otro número? ");
			String res = reader.nextLine();	
			if (res.equals("no"))			//Si el usuario no desea introducir mas números terminamos el programa
				fin = true;	
		}
		
		System.out.println("Saliendo del programa...");
		reader.close();
	}
	
	/**
	 * Metodo que convierte a decimal un número hexadecimal
	 * @param hexString
	 * @return
	 * @throws HexFormatException
	 */
	public static int hex2Decimal(String hexString) throws HexFormatException{
		
		hexString = hexString.toUpperCase();
		int sum = 0;	

		for (int i = 0; i < hexString.length(); i++) {	//Recorremos el string con el número en hexadecimal
			char c = hexString.charAt(i);
			int d = hexChar.indexOf(c);
			
			if(d == -1)					//Si no se encuentra el char en nuestro String hexChar lanzamos la excepción
				throw new HexFormatException("Error al convertir a decimal, formato incorrecto");	//throw
			
			sum = 16 * sum + d;
		}
		return sum;
	}
}
