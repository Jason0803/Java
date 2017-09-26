package servlet.context.editProfile;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
import jdbc.exception.RecordNotFoundException;
import vo.Student;

public class ServletContextWriting_EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext cont;
	private HttpSession session;
	private ArrayList<Student> users;
	private StudentDAO dao;
	private int userClass;
	private String userName;
	private String pw;
	private boolean isUpdated;

	public void init() throws ServletException {
		cont = getServletContext();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		session = request.getSession(true);
		if(session != null) {
			// not sure why the fuck this isn't working with getParam...
			userClass = ((Student)cont.getAttribute("user")).getUserClass();
			users = (ArrayList<Student>)cont.getAttribute("studentDB");
			
			userName = ((Student)cont.getAttribute("user")).getName();
			pw = request.getParameter("newPW");
			
			Student updatedUser = new Student(userClass, userName, pw);
			dao = StudentDAO.getInstance();
			
			try {
				isUpdated = dao.updateUser(updatedUser);
				
				if(isUpdated) {
					cont.setAttribute("user", updatedUser);
					users.add(updatedUser);
					cont.setAttribute("studentDB", users);
					// session invalidate --> go index.html
					session.invalidate();
					System.out.println("SESSION FINISHED ON USER UPDATE !");
					
					request.getRequestDispatcher("index.html").forward(request, response);
				} else {
					System.out.println("Something went wrong on user Update !");
					request.getRequestDispatcher("login_check.jsp").forward(request, response);
				}
				
			} catch (RecordNotFoundException e) {
				System.out.println(e.getMessage());
			}
				
		} else {
			System.out.println("WARNING :: SESSION EXCEPTION !!");
		}
	}

}
