package controller.diary;

import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.dao.member.MemberDAO;
import model.vo.diary.Schedule;
import model.vo.member.Member;
import util.CocoaDate;

public class WriteScheduleController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member vo = (Member)request.getSession().getAttribute("memberVO");
		String id = vo.getId();
		String title = (String)request.getParameter("title");
		String start_date = (String)request.getParameter("start_date"); 
		String end_date = (String)request.getParameter("end_date");
		String content = (String)request.getParameter("content");
		String input = ((String)request.getParameter("group_member"));
		String[] inputMemberIds = new String[1];
		Vector<String> sharedMembers = new Vector<String>();
		Schedule schedule = null;
		System.out.println("=============== INPUT : " + input + " ===============");
		// To check whether the given id exists.
		
		if(input.contains(",")) {
			System.out.println("[WriteScheduleController] : Multiple user input !");

			for(String inputMemberId : input.split(",")) {
				System.out.println("[WriteScheduleController] : givenMemberId : " + inputMemberId);
				sharedMembers.add(inputMemberId);
			}
			
		} else if(input != null){
			System.out.println("[WriteScheduleController] : Single user input : " + input);
				sharedMembers.add(input);
		}
		
		
		schedule = new Schedule(0, id, title, content, sharedMembers, new CocoaDate(start_date), new CocoaDate(end_date));
		System.out.println("[WriteScheduleController] : Filtered Member ids : " + sharedMembers);
		
		 
		System.out.println("[WriteScheduleController] : New Schedule instance created !" + schedule);

		schedule = DiaryDAO.getInstance().writeDiary(schedule);
		System.out.println("[WriteScheduleController] : writeDiary Logic passed !");
		
		
		DiaryDAO.getInstance().setSharingMembers(schedule.getNo(), sharedMembers);
		
		
		return new ModelAndView("DispatcherServlet?command=calView&"
								+"year=" + new CocoaDate(start_date).getYear()
								+"&month="+ new CocoaDate(start_date).getMonth()
								+"&date="+ new CocoaDate(start_date).getDate());
	}
	
}
