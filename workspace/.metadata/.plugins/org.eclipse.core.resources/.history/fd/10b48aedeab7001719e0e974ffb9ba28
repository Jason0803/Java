package controller;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Memo;
import model.vo.diary.Note;
import model.vo.member.Member;

public class NoteListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mvo = (Member) request.getSession().getAttribute("memberVO");
		Vector<Note> note = DiaryDAO.getInstance().getAllNote(mvo.getId());
		request.setAttribute("note", note);
		return new ModelAndView("note_list.jsp");
	}

}
