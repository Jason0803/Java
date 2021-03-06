package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;

public class showContentController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO vo = BoardDao.getInstance().getPostingByNo(no);
		
		request.setAttribute("bvo", vo);
		ModelAndView mv = new ModelAndView();
		mv.setUrl("show_content.jsp");
		mv.setRedirect(false);
		return mv;
	}

}
