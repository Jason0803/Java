package servlet.life.step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	
    public LifeCycleServlet() {
		System.out.println("1. Constructor called by Container...");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. doGet() called by Container...");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body> "
					+ "<h2>LifeCycleMetho...Test</h2><p> "
					+ "<b>Count:: </b>" + ++count 
					+ "</body></html>");
		
		out.close();
		
	}
	
	public void init() throws ServletException {
		System.out.println("2. init() called by Container...");
	}
	
	public void destroy() {
		System.out.println("4. destroy() called by Container...");
	}
}
