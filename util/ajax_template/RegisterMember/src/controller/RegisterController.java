package controller;

import java.net.URLEncoder;

import javax.print.URIException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * 폼에 입력된 값 받아서...id,pass,name,addr
		 * biz()
		 * ModelAndView생성....register_result.jsp(한글처리)
		 */
		response.setHeader("Cache-Control", "no-cache");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		MemberDAO.getInstance().registerMember(vo);
			
		String path = "register_result.jsp";
		return new ModelAndView(path);
		//return new ModelAndView(path,true);
	}

}













