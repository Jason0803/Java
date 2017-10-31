package controller;
public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){
		Controller controller=null;
		if(command.equals("idList")){
			controller = new IdListController();
		}else if(command.equals("findMember")){
			controller = new FindMemberController();
		}else if(command.equals("register")){
			controller = new RegisterController();
		}else if(command.equals("idCheck")){
			controller = new IdCheckController();
		}
		
		return controller;
	}
}






