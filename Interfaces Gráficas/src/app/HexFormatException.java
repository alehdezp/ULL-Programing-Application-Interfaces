/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 14-02-2017
 * 	Programa ejemplo de manejo de Excepciones
 * @author: Alejandro Hern�ndez Padr�n
 *
 */

package app;

/**
 * Excepci�n HexFormatException

 */
public class HexFormatException extends Exception{
	public HexFormatException(String message) {
		super(message);
	}
}
