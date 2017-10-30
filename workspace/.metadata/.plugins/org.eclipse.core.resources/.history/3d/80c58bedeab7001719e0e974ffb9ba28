package controller;

import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Memo;
import model.vo.diary.Note;
import model.vo.diary.Schedule;
import model.vo.member.Member;

public class SearchController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mvo = (Member) request.getSession().getAttribute("memberVO");
		String id = mvo.getId();
		String keyword = request.getParameter("keyword");
		Map<Integer, Memo> memos = DiaryDAO.getInstance().searchMemoByKeyword(id, keyword);
		request.setAttribute("memos", memos);
		Map<Integer, Note> notes = DiaryDAO.getInstance().searchNoteByKeyword(id, keyword);
		request.setAttribute("notes", notes);
//		Map<Integer, Schedule> schedules = DiaryDAO.getInstance().searchScheduleByKeyword(id, keyword);
//		request.setAttribute("schedules", schedules);
		return new ModelAndView("search_result.jsp");
	}

}
