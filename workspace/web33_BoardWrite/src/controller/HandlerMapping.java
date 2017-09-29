package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return handler;	
	}
	
	public Controller createController(String command){
		Controller controller = null;
		if(command.equals("write")){
			controller = new WritePostController();
			System.out.println("WritePostController 생성됨....");
		} else if(command.equals("showContent") ) {
			controller = new showContentController();
			System.out.println("showContentController 생성됨....");
		} else if (command.equals("list")) {
			controller = new ListController();
			System.out.println("ListController 생성됨....");
		}
		
		return controller;
	}
		
}


//itemCartRemove.do
//itemCartQtyDown.do













