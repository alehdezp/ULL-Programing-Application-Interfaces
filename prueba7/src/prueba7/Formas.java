package prueba7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Formas {

	private String outputFile = "salida.txt";
	private String inputFile;
	private ArrayList<String> readFile;
	private final float pi = (float) 3.14;

	public Formas(String inputFile){
		setInputFile(inputFile);
	}

	public void calculaFormas(){

		setReadFile(new ArrayList<String>());
		
		try{		//bloque try

			FileReader fr = new FileReader(getInputFile());
			BufferedReader br = new BufferedReader(fr);
			String lineAux= "";

			while((lineAux = br.readLine())!= null){	//leemos hasta el fin del fichero
				getReadFile().add(lineAux);					//guardamos la lineas en el array
			}
			fr.close();
			br.close();
		}catch(Exception e){
			System.out.println(e);
		}
		for (int i = 0; i < getReadFile().size(); i++) {
			if(getReadFile().get(i).contains("esfera"))
				esfera(getReadFile().get(i));
		}
	}


	public void esfera(String s){
		String line =  s.substring(0, s.indexOf("("));
		line += "< punto en " + s.substring(s.indexOf("("), s.indexOf(")")+ 1);
		line += " Radio =" + s.substring(s.indexOf("= ")+1) + " >";
		String values = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
		String radio = s.substring(s.indexOf("= ")+1);
		line += " Area = " + areaEsfera(Float.parseFloat(radio));
		System.out.println(line);
		
		

	}
	public float areaEsfera(float r){
		return 4 * pi * r;
	}
	
	public float volumenEsfera(float r){
		return (4 * pi *  (int) Math.pow(r, 3))/3;
	}

	/**
	 * @return the outputFile
	 */
	public String getOutputFile() {
		return outputFile;
	}

	/**
	 * @param outputFile the outputFile to set
	 */
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	/**
	 * @return the inputFile
	 */
	public String getInputFile() {
		return inputFile;
	}

	/**
	 * @param inputFile2 the inputFile to set
	 */
	public void setInputFile(String inputFile2) {
		this.inputFile = inputFile2;
	}

	/**
	 * @return the readFile
	 */
	public ArrayList<String> getReadFile() {
		return readFile;
	}

	/**
	 * @param readFile the readFile to set
	 */
	public void setReadFile(ArrayList<String> readFile) {
		this.readFile = readFile;
	}
}
