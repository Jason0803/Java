package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class IdListController implements Controller {

	@Override
		public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setHeader("Cache-Control", "no-cache");
		ArrayList<String> list = MemberDAO.getInstance().getAllIdList();
		
		String path = "show_idList.jsp";
	
		request.setAttribute("list", list);
		return new ModelAndView(path);
	}
}












