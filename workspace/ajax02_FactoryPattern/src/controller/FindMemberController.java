package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberController implements Controller {

	@Override
		public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		MemberVO member = MemberDAO.getInstance().findMemberById(id);
		
		out.print(member.getName()+", "+member.getAddress());
		
		return null;
	}
}












