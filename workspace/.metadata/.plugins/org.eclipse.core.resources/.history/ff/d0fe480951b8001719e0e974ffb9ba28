package controller.diary;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Diary;
import model.vo.diary.Memo;
import model.vo.diary.Note;
import model.vo.member.Member;

public class NoteListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mvo = (Member) request.getSession().getAttribute("memberVO");
		// Vector<Note> note = DiaryDAO.getInstance().getAllNote(mvo.getId());
		// #00158 : getAllDiary Integration
		Vector<Diary> note = DiaryDAO.getInstance().getAllDiary(mvo.getId(), "note");
		request.setAttribute("note", note);
		return new ModelAndView("note_list.jsp");
	}

}
