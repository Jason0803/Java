package controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory(){}
	public static ControllerFactory getInstance(){
		return factory;		
	}
	
	public Controller createController(String command){
		Controller controller = null;
		if(command.equals("find")){
			controller = new FindController();
		}
		return controller;
	}
}

















