package pattern.action;

public class ActionFactory {
	// Singleton Pattern
	private static ActionFactory factory = new ActionFactory();
	private ActionFactory() {}
	public static ActionFactory getFactory() {
		return factory;
	}
	
	public Action createAction(String com) {
		Action action = null;
		
		if(com.equals("INSERT")) {
			action = new InsertAction();
		} else if (com.equals("UPDATE")) {
			action = new UpdateAction();
		} else {
			// com.equals("DELETE")
			action = new DeleteAction();
		}
		
		return action;
	}
}
