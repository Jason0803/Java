package servlet.http.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletTest
 */
public class HttpServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HttpServletTest() {
        
    }

    // default
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// when specify to use POST (on HTML)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// for charset
		response.setContentType("text/html;charset=utf-8");
		
		// 1. Return PrintWriter
		PrintWriter out = response.getWriter();

		
		// 2. PrintWriter > println()
		out.println("<html><body bgcolor='blue'> "
				+ "<h1>오늘은 목요일 !</h1>"
				+ "</body></html>");
		
		
	}

}
