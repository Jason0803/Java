package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextWriting
 */
public class ServletContextWriting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap userList;
	private HashMap user;
	private ServletContext cont;
	
	
	@Override
	public void init() throws ServletException {
		// userList initialization;
		// user = new HashMap<String,String>();
		userList = new HashMap();
		
		cont = getServletContext();
		
		System.out.println(getServletContext().getInitParameter("NAME"));
		//etInitParameter("JOB");
		//getInitParameter("EMAIL");
		// return cont;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//user.put(request.getParameter("userId"), request.getParameter("pw"));
		// userList.put(user.get(1), request.getParameter("userName"));
		
		String userId = request.getParameter("userId");
		String pw = request.getParameter("pw");
		String userName = request.getParameter("userName");
		
		userList.put("userId", userId);
		userList.put("pw", pw);
		userList.put("userName", userName);
		
		
		cont.setAttribute("userList", userList);
		
		
		PrintWriter out = response.getWriter();
		
		System.out.println("doPost() call...");
		
		
		out.println("<html><body bgcolor=pink> "
					+ "<b>============ The Communication Servlets ============ "
					+ "User Information has been binded on ServletContext "
					+ "<a href='SC2'>User List</a>");
		
	}

}
