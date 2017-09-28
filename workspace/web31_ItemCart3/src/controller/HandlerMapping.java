package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return handler;	
	}
	
	public Controller createController(String command){
		Controller controller = null;
		if(command.equals("/itemList.do")){
			controller = new ItemListController();
			System.out.println("ItemListController 생성됨....");
		}else if(command.equals("/itemView.do")){
			controller = new ItemViewController();
			System.out.println("ItemViewController 생성됨....");
		}
		return controller;
	}
}

















