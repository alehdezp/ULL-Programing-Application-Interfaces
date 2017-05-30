/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informática
 * 	Fecha: 14-02-2017
 * 	Programa de ejemplo de uso de JFrames y JPanel en java
 * 	Genera el fichero de código que se le pase por parametro
 * 	en formato html
 * @author: Alejandro Hernández Padrón
 *
 */

package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;


public class Syntax {

		
	private String outFile;					//Fichero de salida html
	private ArrayList<String> javaSyntax;	//Array con la información del fichero de entrada
	private ArrayList<String> html;			//Array con la información formateada a html
	
	private static final ArrayList<String> keywords = new ArrayList<String>
	(Arrays.asList("main", "void", "int", "public", "private", "float", "String",
			"static", "class", "try", "this", "catch"));	//static con las palabras claves
	
	/**
	 * Main principal de programa, envia los dos parametros pasados por
	 * linea de comandos al objeto Syntax
	 * @param args
	 */
	public static void main(String[] args) {
		Syntax file = new Syntax(args[0], args[1]);
		JSyntax frame = new JSyntax();				//Mostramos la ventana
		file.generateHtml();						//Generamos el fichero html
		
		try{ System.in.read();						//Pause
		}catch(Exception e){}
		
		frame.generado();							//Actualizamos la ventana
	}

	/**
	 * Constructor de la clase
	 * Genera el ArrayList con todas las lineas de fichero
	 * pasado por parametro
	 * @param inputFile
	 * @param outFile
	 */
	public Syntax(String inputFile, String outFile){
														//Inicializamos los atributos
		this.outFile = outFile;
		this.javaSyntax = new ArrayList<String>();
		this.html = new ArrayList<String>();
		
		try{	//Bloque try					
			
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);	//Leemos el archivo
			String lineAux= "";
			
			while((lineAux = br.readLine())!= null){	//Mientras no terminemos de leer
				javaSyntax.add(lineAux);				//guardamos las lineas
			}	
			fr.close();				
			br.close();
			
		}catch(Exception e){		//capturamos la excepcion si se genera
			System.out.println(e);
		}
	}
	
	
	/**
	 * Función que genera el html y llama a la función que la
	 * escribe en el fichero
	 */
	public void generateHtml(){		
									//Cabecera del html
		String s = "<html>  "
				+ "<head>  "
				+ "<meta http-equiv= \" Content-Type\" content=\"text/html; charset=ISO-8859-1\">  "
				+ "<title>" + outFile + "</title>"  
                + "</head><body><pre>";
		
		html.add(s);
		
									
		for(int i = 0; i < javaSyntax.size(); i++){		//Leemos el array de entrada
			
			String line = javaSyntax.get(i);
			String[] tokens = line.split("\\s");		//Dividimos en tokens la linea

			
			for(int j = 0; j < tokens.length; j++){	
				
				if(isReserved(tokens[j]))				//Si es palabra reservada
					line = line.replace(tokens[j], "<b>" + tokens[j] + "</b>");
				
				else if(isComment(tokens[j])){			//Si es comentario
					line = line.replace(tokens[j], "<font color=#008000>" + tokens[j]);
					line += "</font>";
					j = tokens.length;
				}else if(isString(tokens[j])){			//Si es una cadena literal
					line = line.replace(tokens[j], "<font color=#3D1BFF>" + tokens[j]);
					j++;
					for(int k = j; k < tokens.length; k++){
						if(isString(tokens[j])){
							k = tokens.length;
							line = line.replace(tokens[j], tokens[j] + "</font>");
						}
						j++;
					}
				}
					
			}
			
			html.add(line);
		}
		
		String end = "</pre></body> </html>";		//Fin del archivo html
		html.add(end);									
		writeHtml();								//Escribimos en el ficher de salida
		
	}
	
	/**
	 * Escribe las linea contenidas en el array html
	 * en el fihcero html pasado
	 */
	public void writeHtml(){
		Writer writer = null;
		try {			//bloque try
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(outFile), "utf-8"));
		    
		    for(int i = 0; i < html.size(); i++)
		    	writer.write(html.get(i) + "\n");
		    writer.close();
		} catch (Exception e) {		//Capturamos la excepcion
		  System.out.println(e);
		}
	}
	
	/**
	 * Compara con el array keywords para comprobar si es una palabra
	 * reservada
	 * @param token
	 * @return
	 */
	public Boolean isReserved(String token){
		return keywords.contains(token);
	}
	
	/**
	 * Comprueba si el token es un comentario
	 * @param token
	 * @return
	 */
	public Boolean isComment(String token){
		if(token.contains("//") || token.contains("/**"))
			return true;
		return false;
	}
	
	/**
	 * Comprueba si el token es un String
	 * @param token
	 * @return
	 */
	public Boolean isString(String token){
		return token.contains("\"");
	}

}
