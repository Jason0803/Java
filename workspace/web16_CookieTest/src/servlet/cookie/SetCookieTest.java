package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Jason
 * First Servlet Page on Server
 * 1. Cookie Created
 * 2. Send to Web Browser
 *
 */
public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// 1.
		Date now = new Date();
		String id = "KOSTA";
		
		Cookie c1 = new Cookie("now", now.toGMTString());
		Cookie c2 = new Cookie("id", id);
		
		c1.setMaxAge(24*60*60); // Cookie remains a day
		c2.setMaxAge(0);
		
		
		out.println("<html><body>");
		out.println("<h2>Cookie created : </h2>" + now + "<hr>");
		out.println("ID : " + id);
		out.println("<a href='GetCookieTest>GetCookieTest'...</a></body></html>");
	
	}

}
