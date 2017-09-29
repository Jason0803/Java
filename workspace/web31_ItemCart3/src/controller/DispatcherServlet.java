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
		//1.원래는 여기서 넘어온 hidden값을 받는 로직이 나왔다.
		/*
		 * hidden값에 따라서 리턴받는 Controller가 달라졌었다.
		 * 이번엔 다른 방법을 사용해보겠다...중요
		 */
		String requestURI=request.getRequestURI();
		System.out.println("RequestURI :: "+requestURI);//web40_ItemCart/itemList.do
		
		String contextPath=request.getContextPath();
		System.out.println("ContextPath :: "+contextPath);//web40_ItemCart
		
		//itemList.do 만 추출하자...
		String command = requestURI.substring(contextPath.length());
		System.out.println(command); //itemList.do
		
		ModelAndView mv = null;
		Controller controller=HandlerMapping.getInstance().createController(command);
		
		try{
			mv=controller.handle(request, response);
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















