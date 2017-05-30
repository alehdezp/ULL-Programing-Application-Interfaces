/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informática
 * 	Fecha: 14-02-2017
 * 	Programa ejemplo de manejo de Excepciones
 * @author: Alejandro Hernández Padrón
 *
 */

package app;

/**
 * Excepción HexFormatException

 */
public class HexFormatException extends Exception{
	public HexFormatException(String message) {
		super(message);
	}
}
