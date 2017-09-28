package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		
		
		/*
		 * 원래는 hiddend으로 넘어온 값을 받아서 command에 할당하는 로직이 처음에 나와야 한다.
		 * 이번에는 조금 다른 방식을 사용해 보겠다.
		 */
		
		String requestURI=request.getRequestURI();
		System.out.println("getRequestURI() :: "+requestURI);//web29_ItemCart/itemList.do
		
		String contextPath=request.getContextPath();
		System.out.println("getContextPath() ::"+contextPath);//web29_ItemCart
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command ::"+command);//web29_ItemCart	
		
		ModelAndView mv = null;
		Controller controller=HandlerMapping.getInstance().createController(command);
		
		try{
			mv=controller.handleRequest(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(mv != null){
			if(mv.isRedirect())
				response.sendRedirect(mv.getUrl());
			else
				request.getRequestDispatcher(mv.getUrl()).forward(request, response);
		}//if
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}















