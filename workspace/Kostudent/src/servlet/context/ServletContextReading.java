package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Student;

/**
 * Servlet implementation class ServletContextReading
 */
public class ServletContextReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext cont;
	private Student user;
	private ArrayList<Student> users;
	
	public void init() throws ServletException {
		cont = getServletContext();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		user = (Student)cont.getAttribute("user");
		ArrayList<Student> attribute = (ArrayList<Student>)cont.getAttribute("users");
		users = attribute;
		
		/*
		if(users.contains(user)) {
			user.setMatch(Student.LOGIN_SUCCESS);
		} else {
			user.setMatch(Student.NO_SUCH_USER_FOUND);
		}
		*/
		
		for(int i = 0; i < users.size(); i++){
			if(user.getUserClass() == users.get(i).getUserClass()) {
				if(user.getName().equalsIgnoreCase(users.get(i).getName())) {
					// when user exists in users (class & name matching)
					if(user.getPassword().equals(users.get(i).getPassword())) {
						// Password matches
						user.setMatch(Student.LOGIN_SUCCESS);
						break;
					} else {
						// Password not matching
						user.setMatch(Student.INCORRECT_PASSWORD);
						break;
					} 
				}
			} else user.setMatch(Student.NO_SUCH_USER_FOUND);
		} // for
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=yellow>");
			switch(user.getMatching() ) {
				case Student.LOGIN_SUCCESS: {
					out.println("Login Success !");
					break;
				}
				case Student.INCORRECT_PASSWORD : {
					out.println("Incorrect Password !");
					break;
				}
				case Student.NO_SUCH_USER_FOUND : {
					out.println("No Such User Found !");
					break;
				}	
			}
	
		out.print("</body></html>");
		out.close();
	}
}
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		user = (Student)cont.getAttribute("user");
		users = (ArrayList<Student>) cont.getAttribute("users");
		
		for(int i = 0; i < users.size(); i++ ){
			if(user.getUserClass() == users.get(0).getUserClass() && user.getName().equals(users.get(0).getName())) {
				// when user exists in users
				if(user.getPassword().equals(users.get(0).getPassword())) {
					// Password matches
					user.setMatch(Student.LOGIN_SUCCESS);
					break;
				} else {
					// Password not matching
					user.setMatch(Student.INCORRECT_PASSWORD);
					break;
				} 
			} else {
				user.setMatch(Student.NO_SUCH_USER_FOUND);
				break;
			} 
		} // for
	
		out = response.getWriter();
		out.println("<html><body bgcolor=yellow>");
		
			switch(user.getMatching() ) {
				case Student.LOGIN_SUCCESS: {
					out.println("Login Success !");
					break;
				}
				case Student.INCORRECT_PASSWORD : {
					out.println("Incorrect Password !");
					break;
				}
				case Student.NO_SUCH_USER_FOUND : {
					out.println("No Such User Found !");
					break;
				}	
			}
	
		out.print("</body></html>");
		out.close();
	}
		
*/


