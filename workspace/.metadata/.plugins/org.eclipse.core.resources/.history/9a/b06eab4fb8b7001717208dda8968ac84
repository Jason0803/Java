package controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.util.ModelAndView;
import dao.member.MemberDAO;
import vo.member.Member;

public class RegisterMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		String path = "cal.jsp?month="+month;
		Member vo = MemberDAO.getInstance().registerMember(new Member(id, password, name, 1, 1));
		HttpSession session = request.getSession();
		session.setAttribute("memberVO", vo);
		return new ModelAndView(path, true);
	}

}
