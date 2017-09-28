package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		
		
		
		ModelAndView mv = null;
		Controller controller=HandlerMapping.getInstance().createController(command);
		
		try{
			mv=controller.handleRequest(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(mv != null){
			if(mv.isRedirect())
				response.sendRedirect(mv.getUrl());
			else
				request.getRequestDispatcher(mv.getUrl()).forward(request, response);
		}//if
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}















