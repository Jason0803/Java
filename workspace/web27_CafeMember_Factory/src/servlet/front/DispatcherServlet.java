package servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ControllerFactory;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

//로직은 여기다...
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		Controller controller=ControllerFactory.getInstance().createController(command);
		
		try{
			path=controller.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}//
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}






















