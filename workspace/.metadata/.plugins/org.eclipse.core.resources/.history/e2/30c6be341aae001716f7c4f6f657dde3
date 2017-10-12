package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;

public class DeletePostingController implements Controller {

	@Override
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao.getInstance().deletePosting(no);
		String path = "DispatcherServlet?command=list";
		return new ModelAndView(path,true);
	}

}
