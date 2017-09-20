package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext cont;
	private HashMap userList;
	
	public void init() throws ServletException {
		cont = getServletContext();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		userList = (HashMap)cont.getAttribute("userList");
		out.println("<html><body color=yellow> "
					+ "UserId : " + userList.get("userId") 
					+ "Password : " + userList.get("pw") 
					+ "UserName : " + userList.get("userName"));
		
		out.close();
	}

}
