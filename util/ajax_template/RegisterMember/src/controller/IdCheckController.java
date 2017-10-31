package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdCheckController implements Controller {

	@Override
		public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		boolean flag=MemberDAO.getInstance().isExist(id);
		
		String path = "idcheck.jsp";
		request.setAttribute("flag", flag);
		return new ModelAndView(path);
	}
}












