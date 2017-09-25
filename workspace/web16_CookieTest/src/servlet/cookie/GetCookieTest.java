package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Jason
 *	Second Servlet
 *	
 */
public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2>SetCookieTest...find cookie infor..</h2><p>");
		Cookie[] cs = request.getCookies();
		
		for(Cookie cookie : cs) {
			out.println(cookie.getName() + " :: " + cookie.getValue() + "<hr>");
		}
		
		out.println("</body></html>");
		
		
	}

}
