package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		System.out.println("JSESSION ID : " + session.getId());
		
		session.setAttribute("name", "KOSTA");
		
		request.getRequestDispatcher("Second").forward(request, response);
	}

}
