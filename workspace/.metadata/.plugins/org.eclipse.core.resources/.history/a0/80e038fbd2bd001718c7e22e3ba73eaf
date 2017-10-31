package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public DispatcherServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command=request.getParameter("command");//idList,register
		Controller controller=HandlerMapping.getInstance().create(command);
		String path="error.jsp";
		ModelAndView mv=null;
		boolean isRedirect=true;
		try {
			mv=controller.execute(request, response);
			if(mv==null) // ModelAndView 가 null 일 경우 수행을 중단한다. 
				return;
			path=mv.getPath();
			isRedirect=mv.isRedirect();
		} catch (Exception e) {		
			e.printStackTrace();
		}
		if(isRedirect){				
			response.sendRedirect(path);
		}else{
			request.getRequestDispatcher(path).forward(request, response);
		}			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}







