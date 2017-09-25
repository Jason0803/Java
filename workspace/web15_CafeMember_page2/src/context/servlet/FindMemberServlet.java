package context.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.model.MemberDAO;
import context.model.MemberVO;

public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	//vo | pvo | rvo
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	
		String id = request.getParameter("id");
		try {
			MemberVO rvo=MemberDAO.getInstance().findByIdMember(id);
			if(rvo != null) out.println(id+" 에 해당하는 정보 출력 : "+rvo);
			else out.println(id+" 에 해당하는 사람 없어요...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}














