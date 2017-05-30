/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3º de Ingieneria Informática
 * 	Fecha: 14-02-2017
 * 	Programa de ejemplo de uso de JFrames y JPanel en java
 * 	Escribe por pantalla las palabras que no es encuentran duplicadas
 * 	en el ficheor de entrada
 * @author: Alejandro Hernández Padrón
 *
 */

package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class NoDuplicadas {
	private String inputFile;		//ficherro de entrada	
	private ArrayList<String> allWords;		//Array con todas las palabras del fichero

	/**
	 * Main de programa principal, incializa los objetos
	 * @param args
	 */
	public static void main(String[] args) {
		NoDuplicadas palabras = new NoDuplicadas("examples/palabras.txt");	//fichero a leer
		JNoDuplicadas frame = new JNoDuplicadas(palabras.printNoDuplicates());	//mostramos las palbras que no estan duplicadas
																				//por la ventana y la consola
	}
	
	public NoDuplicadas(String inputFile){			
													//inicializamos
		this.allWords = new ArrayList<String>();
		
		try{		//bloque try
			
			FileReader fr = new FileReader(this.inputFile);
			BufferedReader br = new BufferedReader(fr);
			String lineAux= "";
			
			while((lineAux = br.readLine())!= null){	//leemos hasta el fin del fichero
				allWords.add(lineAux);					//guardamos la lineas en el array
			}
			fr.close();
			br.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Función que imprime las palabras no duplicadas del fichero
	 * @return
	 */
	public ArrayList<String> printNoDuplicates(){	
		ArrayList<String> noDup = new ArrayList<String>(allWords);	//Creamos un array auxiliar de copia
		
		for (int i = 0; i < noDup.size(); i++){			//recorremos el vectro auxiliar
			String word = noDup.get(i);
			if(noDup.indexOf(word) != noDup.lastIndexOf(word)){		//Si encontramos otra palabra
				while(noDup.remove(word) == true);					//las borramos todas de la lista
			}
		}
		for (int i = 0; i < noDup.size(); i++){			//imprimimos la lista
				System.out.println(noDup.get(i));
		}
		return noDup;				//retornamos el array con la solución
		
	}
}
