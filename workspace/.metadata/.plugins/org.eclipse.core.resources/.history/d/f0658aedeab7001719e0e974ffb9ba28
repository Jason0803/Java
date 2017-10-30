package controller;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Memo;
import model.vo.member.Member;

public class MemoListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mvo = (Member) request.getSession().getAttribute("memberVO");
		Vector<Memo> memos = DiaryDAO.getInstance().getAllMemo(mvo.getId());
		request.setAttribute("memos", memos);
		return new ModelAndView("memo_list.jsp");
	}

}
