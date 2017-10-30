package controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.util.ModelAndView;
import dao.member.MemberDAO;
import util.CocoaDate;
import vo.member.Member;

public class RegisterMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		CocoaDate today = new CocoaDate();
		
		String path = "DisppatcherServlet?year="+today.getYear()+"&month="+today.getMonth();
		Member vo = MemberDAO.getInstance().registerMember(new Member(id, password, name, 1, 1));
		if(vo == null) {
			path = "register?register=false";
		} else{
			HttpSession session = request.getSession();
			
			session.setAttribute("memberVO", vo);
			session.setAttribute("today", today);
		}
		return new ModelAndView(path, true);
	}

}
