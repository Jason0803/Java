package listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import servlet.vo.PersonVO;

public class DriverLoadingListener implements ServletContextListener {
	private ServletContext cont;
	private ArrayList<PersonVO> list; 
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		cont = arg0.getServletContext();
		list = new ArrayList<PersonVO>();
		
		String driver = cont.getInitParameter("ODriver");
		try {
			Class.forName(driver);
			System.out.println("Test Driver Connected !");
		} catch (ClassNotFoundException e) {
			System.out.println("No such Driver Found !");
		}
		
		/*
		cont = arg0.getServletContext();
		users = new ArrayList<Student>();
	
		String fileName = cont.getInitParameter("userFile");
		*/
		
	}

}
