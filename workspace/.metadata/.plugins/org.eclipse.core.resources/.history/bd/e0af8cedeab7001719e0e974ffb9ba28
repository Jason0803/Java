package controller;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Memo;
import model.vo.diary.Schedule;
import model.vo.member.Member;
import util.CocoaDate;

public class UpdateScheduleController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Member mvo = (Member) request.getSession().getAttribute("memberVO");									// Jason : NOT Required ?
		Schedule schedule = 
				DiaryDAO.getInstance().updateSchedule(Integer.parseInt(request.getParameter("diaryNo")), 		// no
														request.getParameter("title"),							// title
														request.getParameter("content"), 						// content	
														new CocoaDate(request.getParameter("start_date")), 		// start_date
														new CocoaDate(request.getParameter("end_date")));		// end_date
		request.setAttribute("schedule", schedule);
		return new ModelAndView("update_schedule.jsp");
	}

}
