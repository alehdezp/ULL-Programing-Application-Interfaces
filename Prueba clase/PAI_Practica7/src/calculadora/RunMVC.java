package calculadora;

import java.util.Scanner;

public class RunMVC {


	public RunMVC() {
		Model myModel 	= new Model();
		View myView 	= new View();

		myModel.addObserver(myView);
		Controller myController = new Controller();
		myController.addModel(myModel);
		myController.addView(myView);


		myView.addController(myController);

		float euro = 1;
		myController.setModel(euro);
		Scanner sn = new Scanner(System.in);
		
		while(euro != 0){
			System.out.print("Cantidad de euros a convertir (0 = exit): ");
			euro = sn.nextInt();
			myController.setModel(euro);
		}
		sn.close();
	} //RunMVC()

} //RunMVC


