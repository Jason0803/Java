package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;

public class DispatcherServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String command = request.getRequestURI().substring(request.getContextPath().length());
		String command = request.getParameter("command");
		Controller controller = HandlerMapping.getHandler().handleRequest(command);
		try {
			ModelAndView mav = controller.handle(request, response);
			if(!mav.isRedirect()) request.getRequestDispatcher(mav.getPath()).forward(request, response);
			else response.sendRedirect(mav.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
