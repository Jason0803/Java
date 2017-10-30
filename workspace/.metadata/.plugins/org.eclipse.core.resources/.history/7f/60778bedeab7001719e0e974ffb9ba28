package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Schedule;
import model.vo.member.Member;

public class ScheduleViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mvo = (Member)request.getSession().getAttribute("memberVO");
		Schedule schedule = DiaryDAO.getInstance().getScheduleByNo(Integer.parseInt(request.getParameter("diaryNo")));
		request.setAttribute("schedule", schedule);
		return new ModelAndView("schedule_view.jsp");
	}

}
