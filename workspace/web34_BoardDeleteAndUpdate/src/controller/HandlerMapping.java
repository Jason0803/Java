package controller;
/*
 * DisoatcherServlet이 건네주는 command 값에 따라서
 * Controller의 구상객체를 만들어내는 일종의 공장 역할..
 * 싱글톤으로 작성...
 */
public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return handler;
	}
	
	public Controller createController(String command){
		Controller controller = null;
		if(command.equals("write")){
			controller = new WriteController();
		}else if(command.equals("showContent")){
			controller = new ShowContentController();
		}else if(command.equals("list")){
			controller = new ListController();
		}else if(command.equals("deleteCheckPassword")){
			controller = new DeleteCheckPasswordController();
		}else if(command.equals("deletePosting")){
			controller = new DeletePostingController();
		}
		return controller;
	}
}














