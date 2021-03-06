package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;
import sql.StringQuery;

public class WritePostController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardDao dao = BoardDao.getInstance();
		BoardVO post = new BoardVO(title, writer, password, content);
		dao.posting(post);
		
		ArrayList<BoardVO> list = BoardDao.getInstance().getAllPosts(); 
		list.add(post);
		
		String path = "DispatcherServlet?command=showContent&&no=" + post.getNo();
		
		request.setAttribute("bvo", post);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl(path);
		mv.setRedirect(true);
		return mv;
	}

}
