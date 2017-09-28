package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindController implements Controller{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = "find_fail.jsp";
		String id= request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO rvo=dao.findMemberById(id);
		
		if(rvo != null){
			request.setAttribute("mvo", rvo);
			path = "find_ok.jsp";
		}
		return path;
	}

}















