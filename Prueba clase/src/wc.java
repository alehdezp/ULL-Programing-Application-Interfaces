import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class wc {

	ArrayList<String> line;
	String inputFile;

	int nPalabras, nLineas, nCaracteres;
	
	


	public static void main(String[] args) {
		wc comando = new wc(args[0]);
		comando.run();
	}
	
	public wc (String inputFile){
		//inicializamos
		this.line = new ArrayList<String>();
		setInputFile(inputFile);

		try{		//bloque try

			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			String lineAux= "";

			while((lineAux = br.readLine())!= null){	//leemos hasta el fin del fichero
				addLine(lineAux);					//guardamos la lineas en el array
			}
			fr.close();
			br.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public void run (){
		
		setnPalabras(0);
		setnCaracteres(0);
		setnLineas(line.size());
		int cPalabras = 0;
		int cCaracteres = 0;
		
		
		for (int i = 0; i < line.size(); i++){
			String words = getLine(i);
			String[] cont = words.split("\\s+");
			cPalabras += cont.length;
			cCaracteres += words.length();
			
		}
		setnPalabras(cPalabras);
		setnCaracteres(cCaracteres);
		
		
		System.out.println(getnPalabras() + "  " + getnLineas() + "  " + getnCaracteres() + "   " + getInputFile());
	}
	
	public void addLine(String s){
		line.add(s);
	}
	
	public String getLine(int i){
		return line.get(i);
	}

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
	 * @return the nPalabras
	 */
	public int getnPalabras() {
		return nPalabras;
	}

	/**
	 * @param nPalabras the nPalabras to set
	 */
	public void setnPalabras(int nPalabras) {
		this.nPalabras = nPalabras;
	}

	/**
	 * @return the nLineas
	 */
	public int getnLineas() {
		return nLineas;
	}

	/**
	 * @param nLineas the nLineas to set
	 */
	public void setnLineas(int nLineas) {
		this.nLineas = nLineas;
	}

	/**
	 * @return the nCaracteres
	 */
	public int getnCaracteres() {
		return nCaracteres;
	}

	public void setnCaracteres(int nCaracteres) {
		this.nCaracteres = nCaracteres;
	}
}




