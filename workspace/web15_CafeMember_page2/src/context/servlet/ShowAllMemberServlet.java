package context.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.model.MemberDAO;
import context.model.MemberVO;

public class ShowAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		try {
			ArrayList<MemberVO> rList=dao.showAllMember();
			request.setAttribute("list", rList);
			request.getRequestDispatcher("showAll.jsp").forward(request, response);
		}catch(SQLException e) {
			System.out.println("전체회원 명단을 가져오는데 실패했습니다...");
		}
	}

}












