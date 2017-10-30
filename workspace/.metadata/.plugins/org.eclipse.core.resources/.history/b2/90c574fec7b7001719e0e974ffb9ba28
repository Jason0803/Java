package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import dao.diary.DiaryDAO;
import util.CocoaDate;
import vo.diary.Schedule;
import vo.member.Member;

public class DeleteDiaryController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mvo = (Member)request.getSession().getAttribute("memberVO");
		CocoaDate today = new CocoaDate();
		int no = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("no", no);
		String path = "cal.jsp?year="+today.getYear()+"&month="+today.getMonth();
		
		return new ModelAndView(path);
	}

}


