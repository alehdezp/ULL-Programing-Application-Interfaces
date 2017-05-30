import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CuentaLineas {


	public static void main(String[] args) {
		CuentaLineas c = new CuentaLineas();
		c.cuenta(args);
	}
	public CuentaLineas(){
	}

	public void cuenta(String[] inputFile){

		for(int i = 0; i < inputFile.length; i++){


			int nLineas = 0; 
			try{		//bloque try

				FileReader fr = new FileReader(inputFile[i]);
				BufferedReader br = new BufferedReader(fr);
				String lineAux= "";

				while((lineAux = br.readLine())!= null){	//leemos hasta el fin del fichero
					nLineas++;					//guardamos la lineas en el array
				}
				fr.close();
				br.close();
			}catch(Exception e){
				System.out.println(e);
			}
			System.out.println(" El fichero "+ inputFile[i] + " tiene " + nLineas + " lineas");
		}
	}
	
	

}
