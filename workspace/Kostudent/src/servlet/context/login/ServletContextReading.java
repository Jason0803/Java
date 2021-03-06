package servlet.context.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Student;

public class ServletContextReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext cont;
	private Student user;
	private ArrayList<Student> users;
	HttpSession session;
	private String path = "index.html";
	
	public void init() throws ServletException {
		cont = getServletContext();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		user = (Student)cont.getAttribute("user");
		users = (ArrayList<Student>)cont.getAttribute("studentDB");
		
		for(int i = 0; i < users.size(); i++){
			if(user.getUserClass() == users.get(i).getUserClass()) {
				if(user.getName().equalsIgnoreCase(users.get(i).getName())) {
					// when user exists in users (class & name matching)
					if(user.getPassword().equals(users.get(i).getPassword())) {
						// Password matches
						user.setMatch(Student.LOGIN_SUCCESS);
						path = "login_check.jsp";
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
		
		session = request.getSession(true);
		System.out.println("Log-In JSESSION ID : " + session.getId());
		
		session.setAttribute("login_result", user.getMatching() + " ");
		session.setAttribute("name", user.getName());
		cont.setAttribute("user", user);
		
		System.out.println("Login Result : " + session.getAttribute("login_result"));
		System.out.println("Login Name : " + session.getAttribute("name"));
		request.getRequestDispatcher(path).forward(request, response);
		
		
		out.println("<hr><a href='index.html'>Go Back to Home</a>");
		out.println("</body></html>");
		out.close();
	}
	

}