package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class ShowContentController implements Controller {

	@Override
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO rvo=BoardDao.getInstance().getPostingByNo(no);
		
		request.setAttribute("bvo", rvo);
		return new ModelAndView("show_content.jsp",false); //forward
	}

}
