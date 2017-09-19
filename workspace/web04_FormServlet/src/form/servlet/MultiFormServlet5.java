package form.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultiFormServlet5
 */
public class MultiFormServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Input values from forms...</h2>");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		out.println("<li> ID : " + id + "</li><br>");
		out.println("<li> PW : " + pw + "</li><br>");
	}

}
