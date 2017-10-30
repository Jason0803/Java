package controller.diary;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Diary;
import model.vo.diary.Memo;
import model.vo.member.Member;

public class MemoListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mvo = (Member) request.getSession().getAttribute("memberVO");
		//Vector<Memo> memos = DiaryDAO.getInstance().getAllMemo(mvo.getId());
		// #00161 : Apply getAllDiary
		Vector<Diary> memos = DiaryDAO.getInstance().getAllDiary(mvo.getId(), "memo");
		request.setAttribute("memos", memos);
		return new ModelAndView("memo_list.jsp");
	}

}
