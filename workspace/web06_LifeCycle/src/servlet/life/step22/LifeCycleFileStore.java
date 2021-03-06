package servlet.life.step22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleFileStore
 */
public class LifeCycleFileStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path = "/Users/Jason/Desktop/filestore/life/step2/count.txt";
	// private String fileName = "count.txt";
	
    public LifeCycleFileStore() {
    	System.out.println("1. Servlet Creating...");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("2. init() called by Container...");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			//ÇÊµå¿¡ ÇÒ´ç
			count = Integer.parseInt(str);
			System.out.println("ÆÄÀÏ¿¡¼­ ÀÐ¾îµéÀÎ count °ª :: "+count);
			br.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}	
	}

	public void destroy() {
		System.out.println("4. destroy() called by Container...");


		File file = new File(path);
		file.getParentFile().mkdirs();
			try {
				PrintWriter pw =new PrintWriter(new FileWriter(file));
				pw.print(count);
				pw.close();
				System.out.println(path+" count :: "+count + " has been saved");
			}catch(IOException e) {
				System.out.println("Could not find directory..");
			}
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. doGet() called by Container...");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor='yellow'> "
					+ "<h2>LifeCycleMetho...Test</h2><p> "
					+ "<b>Count:: </b>" + ++count 
					+ "</body></html>");
		
		out.close();
	}

}
