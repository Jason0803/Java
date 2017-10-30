package controller;

import controller.calendar.*;
import controller.diary.*;
import controller.member.*;


public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getHandler() {
		return handler;
	}
	
	public Controller handleRequest(String command) {
		
		Controller controller = null;
		
		switch(command) {
			case "login" : {
				controller = new LoginController();
				break;
			}
			case "register" : {
				controller = new RegisterMemberController();
				break;
			}
			case "updateMember" : {
				controller = new UpdateMemberController();
				break;
			}
			case "writeMemo" : {
				controller = new WriteMemoController();
				break;
			}
			case "memoList" : {
				controller = new MemoListController();
				break;
			}
			case "cal" : {
				controller = new CalendarController();
				break;
			}
			case "search" : {
				controller = new SearchController();
				break;
			}
			case "writeNote" : {
				controller = new WriteNoteController();
				break;
			}
			case "noteView" : {
				controller = new NoteViewController();
				break;
			}
			case "scheduleView" : {
				controller = new ScheduleViewController();
				break;
			}
			case "deleteDiary" : {
				controller = new DeleteDiaryController();
				break;
			}
			case "updateNote" : { 
				controller = new UpdateNoteController();
				break;
			}
			case "updateSchedule" : {
				controller = new UpdateScheduleController();
				break;
			}
			case "calView" : {
				controller = new CalendarViewController();
				break;
			}
			case "writeSchedule" : {
				controller = new WriteScheduleController();
				break;
			}
			case "logout" : {
				controller = new LogoutController();
				break;
			}
		}
		/*
		if(command.equals("register")) {
			controller = new RegisterMemberController();
		} else if(command.equals("login")) {
			controller = new LoginController();
		} else if(command.equals("updateMember")) {
			controller = new UpdateMemberController();
		} else if(command.equals("writeMemo")) {
			controller = new WriteMemoController();
		} else if(command.equals("memoList")) {
			controller = new MemoListController();
		} else if(command.equals("cal")) {
			controller = new CalendarController();
		} else if(command.equals("search")) {
			controller = new SearchController();
		} else if(command.equals("writeNote")) {
			controller = new WriteNoteController();
		}
		*/
		return controller;
	}
}
