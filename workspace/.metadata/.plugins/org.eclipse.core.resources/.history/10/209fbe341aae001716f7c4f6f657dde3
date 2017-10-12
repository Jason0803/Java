package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;

public class DeleteCheckPasswordController implements Controller {

	@Override
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//no, password
		int no = Integer.parseInt(request.getParameter("no"));
		String pass = request.getParameter("password");
		
		boolean flag=BoardDao.getInstance().checkPassword(no, pass);//true, false
		request.setAttribute("flag", flag);
		return new ModelAndView("delete_checkpass_result.jsp");
	}

}
