package controller.calendar;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.day.Day;
import model.vo.diary.Diary;
import model.vo.member.Member;
import util.CocoaDate;


public class CalendarController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member vo = (Member)request.getSession().getAttribute("memberVO");
		String id = vo.getId();
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		System.out.println(year);
		CocoaDate date = new CocoaDate(year, month, 1);
		Vector<Diary> schedules = DiaryDAO.getInstance().getAllDiary(id, "schedule");
		//Collections.reverse(schedules);
		
		
		request.setAttribute("monthlyDiary", DiaryDAO.getInstance().getMonthlyDiary(id, date));
		request.setAttribute("scheduleList",  schedules);
		return new ModelAndView("cal.jsp?year="+year+"&month="+month);
	}

}
