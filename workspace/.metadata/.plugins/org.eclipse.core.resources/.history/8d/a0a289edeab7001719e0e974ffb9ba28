package controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.util.ModelAndView;
import model.dao.member.MemberDAO;
import model.vo.member.Member;
import util.CocoaDate;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		CocoaDate today = new CocoaDate();
		String path = "DispatcherServlet?command=cal&year="+today.getYear()+"&month="+today.getMonth();
		Member vo = MemberDAO.getInstance().login(id, password);
		if(vo==null) path = "login.jsp?login=false";
		else {
			HttpSession session = request.getSession();
			session.setAttribute("memberVO", vo);
			session.setAttribute("today", new CocoaDate());
		}
		return new ModelAndView(path, true);
	}

}
