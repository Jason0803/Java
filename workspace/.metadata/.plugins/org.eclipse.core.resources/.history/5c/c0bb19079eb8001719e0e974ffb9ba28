package controller.member;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.dao.member.MemberDAO;
import model.vo.member.Member;

public class UpdateMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("new_password");
		String name = request.getParameter("name");
		int accountPlan = 1;
		int theme = 1;
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		String path = "cal.jsp?month="+month;
		Member vo = MemberDAO.getInstance().updateMember(new Member(id, password, name, accountPlan, theme), newPassword);
		if(vo==null) path = "updateMember.jsp";
		else {
			HttpSession session = request.getSession();
			session.setAttribute("memberVO", vo);
		}
		return new ModelAndView(path, true);
	}

}
