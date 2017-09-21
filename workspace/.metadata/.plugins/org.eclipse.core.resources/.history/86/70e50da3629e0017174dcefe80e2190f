package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Student;

/**
 * Servlet implementation class ServletContextWriting
 */
public class ServletContextWriting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student user;
	private ServletContext cont;
	
	public void init() throws ServletException {
		cont = getServletContext();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//user.put(request.getParameter("userId"), request.getParameter("pw"));
		// userList.put(user.get(1), request.getParameter("userName"));
		
		int userClass = Integer.parseInt(request.getParameter("userClass"));
		String userName = request.getParameter("usr");
		String pw = request.getParameter("pwd");

		
		user = new Student(userClass, userName, pw);

		cont.setAttribute("user", user);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor=pink> "
				+ "<b>============ The Communication Servlets ============ "
				+ "User Information has been binded on ServletContext "
				+ "<a href='SC_checkLogin'>User List</a>");
	}
	

}
