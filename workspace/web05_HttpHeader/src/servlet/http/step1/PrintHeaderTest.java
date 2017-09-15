package servlet.http.step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintHeaderTest
 */
public class PrintHeaderTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='yellow' "
				+ "<h2>Header Information Print..</h2><p> ");
		
		Enumeration<String> enu = request.getHeaderNames();
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = request.getHeader(name);
			
			out.println(name + " : " + value + "<br>");
		}
		
		out.println("</body></html>");
		// out.println(request.getHeaders(request.getHeaderNames()));
		out.close();
	}

}
