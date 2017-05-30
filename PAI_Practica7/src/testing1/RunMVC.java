package testing1;

public class RunMVC {

	private int start_value = 10;	//initialise model, which in turn initialises view

	public RunMVC() {
		Model myModel 	= new Model();
		View1 myView 	= new View1();

		myModel.addObserver(myView);
		Controller myController = new Controller();
		myController.addModel(myModel);
		myController.addView(myView);
		myController.initModel(start_value);

		myView.addController(myController);
		myView.addModel(myModel);
	} //RunMVC()

} //RunMVC


