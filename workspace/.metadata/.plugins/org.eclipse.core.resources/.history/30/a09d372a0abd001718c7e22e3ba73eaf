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
import util.MailSender;
public class ForgotPasswordController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "login.jsp";
		Member vo = MemberDAO.getInstance().findMemberById(id);
		if(vo != null) {
			MailSender.sendMail(id, "forgotPassword", null);
			System.out.println("[ForgotPasswordController] : SendMailSuccess !");
		}
		
		return new ModelAndView(path);
	}

}
