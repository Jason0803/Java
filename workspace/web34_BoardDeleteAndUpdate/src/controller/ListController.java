package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import model.BoardDao;
import model.BoardVO;

public class ListController implements Controller {

	@Override
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardVO> rlist=BoardDao.getInstance().getAllPost();
		System.out.println("getAllPost()...call...");
		
		request.setAttribute("list", rlist);
		return new ModelAndView("show_list.jsp");
	}

}
