package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;
import model.BoardVO;
/*
 * 주석...
 * 폼의 값 받아서
 * pvo 생성
 * biz() 호출
 * 네비게이션..redirect
 */
public class WriteController implements Controller{

	@Override
	public ModelAndView handlerRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardVO pvo = new BoardVO(title, writer, password,content);
		
		BoardDao.getInstance().posting(pvo);
		
		String path = "DispatcherServlet?command=showContent&&no="+pvo.getNo();
		return new ModelAndView(path,true);//전형적인 Redirect 방식
	}
}


















