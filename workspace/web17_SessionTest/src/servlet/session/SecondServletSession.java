package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServletSession
 */
public class SecondServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println("<html><body>");
		if(session.getAttribute("name") != null) {
			String name = (String)session.getAttribute("name");
			out.println("Session Name : " + name + "<br>");
			out.println("JSESSIONID Value :" + session.getId());
			out.println("<hr>");
			out.println("<a href='Third'>Third...</a>");
		}
		out.print("</body></html>");
	}
}
