package listener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletListener implements ServletContextListener {
	private ServletContext cont;
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed Called...");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized Called...");
		
		cont = arg0.getServletContext();
		String fileName = cont.getInitParameter("userFile");
		
		System.out.println("File Name : " + fileName);
		
		InputStream is = null;
		BufferedReader br = null;
		try {
			is = cont.getResourceAsStream(fileName);
			br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			String id = "";
			String pw = "";
			while( (line = br.readLine()) != null ){
				id = line.substring(0, line.indexOf("|"));
				pw = line.substring(line.indexOf("|")+1);
				
				System.out.println("ID : " + id + "\nPassword : " + pw);
			}
		} catch(Exception e) {
			
		}
	}
	/*
	 * ServletContextEvent listen.
	 * ServletContextEvent created on readomg context-param from ServletContext
	 */
}
