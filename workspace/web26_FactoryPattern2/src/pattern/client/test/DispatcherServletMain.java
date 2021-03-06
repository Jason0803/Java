package pattern.client.test;

import pattern.action.Action;
import pattern.action.ActionFactory;

public class DispatcherServletMain {

	public static void main(String[] args) {
		String command = "INSERT";
		
		ActionFactory factory = ActionFactory.getFactory();
		Action action = factory.createAction(command);
		action.execute();
	}
	
}
