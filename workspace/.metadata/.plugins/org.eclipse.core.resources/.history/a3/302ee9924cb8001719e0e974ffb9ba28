package controller.member;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.dao.member.MemberDAO;
import model.vo.member.Member;
import util.CocoaDate;

public class RegisterMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		CocoaDate today = new CocoaDate();
		
		String path = null;
		Member vo = MemberDAO.getInstance().registerMember(new Member(id, password, name, 1, 1));
		if(vo == null) {
			path = "register.jsp?register=false";
		} else{
			path = "DisppatcherServlet?year="+today.getYear()+"&month="+today.getMonth();
			HttpSession session = request.getSession();
			
			session.setAttribute("memberVO", vo);
			session.setAttribute("today", today);
		}
		return new ModelAndView(path, true);
	}

}
