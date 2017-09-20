package servlet.listener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import vo.Student;

public class LoginListener implements ServletContextListener{
	private ServletContext cont;
	ArrayList<Student> users;
	private int userClass;
	private String userName;
	private String password;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed Called...");
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		cont = arg0.getServletContext();
		users = new ArrayList<Student>();
		
		String fileName = cont.getInitParameter("userFile");
		
		System.out.println("File Name : " + fileName);
		
		InputStream is = null;
		BufferedReader br = null;
		String[] userLine;
		String line = "";
		Student temp;
		
		try {
			is = cont.getResourceAsStream(fileName);
			br = new BufferedReader(new InputStreamReader(is));
			int i = 0;
			while( (line = br.readLine()) != null) {
				userLine = line.split("-");
				System.out.println("userLine:"+ userLine[0] + " " + userLine[1] + " " + userLine[2]);
				
				temp = new Student(Integer.parseInt(userLine[0]), userLine[1], userLine[2]);
				
				users.add(temp);
			}
			
			System.out.println("Users : " + users);
			cont.setAttribute("users", users);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
