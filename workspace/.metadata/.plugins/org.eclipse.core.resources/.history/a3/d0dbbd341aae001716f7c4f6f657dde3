package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		Controller controller=  
				HandlerMapping.getInstance().createController(command);
		
		String path = "error.jsp";
		ModelAndView mv = null;
		boolean isRedirect = true;
		try{
			mv = controller.handlerRequest(request, response);
			path = mv.getPath();
			isRedirect=mv.isRedirect();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(isRedirect){
			response.sendRedirect(path);
		}else{
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
