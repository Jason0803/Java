package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.MemberDAO;
import model.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO rvo = dao.findMemberById(id);
		
		
		return new ModelAndView("find_ok", "mvo", rvo.getName() + " Found !");
	}
	
}
