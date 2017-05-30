import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Histograma {

	String inputFile;
	ArrayList<String> lines;
	HashMap<String, Integer> caracter;
	int max;
	
	public static void main(String[] args) {
		Histograma histogram = new Histograma(args[0]);
		histogram.write(args[1]);
	}

	public Histograma(String inputFile){
		this.lines = new ArrayList<String>();
		setInputFile(inputFile);
		caracter = new HashMap<String, Integer>();
		
		try{		//bloque try

			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			String lineAux= "";

			while((lineAux = br.readLine())!= null){	//leemos hasta el fin del fichero
				addLines(lineAux);					//guardamos la lineas en el array
			}
			fr.close();
			br.close();
		}catch(Exception e){
			System.out.println(e);
		}

	}

	public void write(String outputFile){
		setMax(0);
		for (int i = 0; i < lines.size(); i++) {
			String linea = lines.get(i);
			for (int j = 0; j < linea.length(); j++){
				if(""+ linea.charAt(j) == "\\s+"){
					
				}else if(caracter.containsKey("" + linea.charAt(j))){
					int value = caracter.get("" + linea.charAt(j)) + 1;
					caracter.put("" + linea.charAt(j), value);

				}else{
					caracter.put("" + linea.charAt(j), 1);		
					setMax(getMax() + 1);
				}
			}		
		}


		Writer writer = null;

		try {			//bloque try

			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outputFile), "utf-8"));

			for(int i = 0; i < getMax(); i++){
				String maxKey = "";
				int maxValue=0;


				for (Map.Entry<String, Integer> entry : caracter.entrySet()) {
//					writer.write(entry.getKey()+ " = " + entry.getValue() + "\n");
					if(entry.getValue() > maxValue){
						maxKey = entry.getKey();
						maxValue = entry.getValue();
					}

				}
				caracter.remove(maxKey);
				if (!maxKey.equals(""))
					writer.write(maxKey+ " = " + maxValue + "\n");

			}
			writer.close();
		} catch (Exception e) {		//Capturamos la excepcion
			System.out.println(e);
		}

	}

	public void addLines(String s){
		lines.add(s);
	}

	/**
	 * @return the inputFile
	 */
	public String getInputFile() {
		return inputFile;
	}
	/**
	 * @param inputFile the inputFile to set
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	/**
	 * @return the lines
	 */
	public String getLines(int i) {
		return lines.get(i);
	}
	/**
	 * @param lines the lines to set
	 */


	/**
	 * @return the caracter
	 */
	public HashMap<String, Integer> getCaracter() {
		return caracter;
	}

	/**
	 * @param caracter the caracter to set
	 */
	public void setCaracter(HashMap<String, Integer> caracter) {
		this.caracter = caracter;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}


}
