package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Memo;
import model.vo.diary.Note;
import model.vo.member.Member;
import util.CocoaDate;

public class WriteNoteController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member vo = (Member)request.getSession().getAttribute("memberVO");
		String id = vo.getId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// #00116
		Note note =
				DiaryDAO.getInstance().writeDiary(new Note(0, id, new CocoaDate(), content, new CocoaDate(), title));
		
		
		// #10006 NoteView 플로우 관련 #12
		return new ModelAndView("DispatcherServlet?command=noteView&diaryNo=" + note.getNo() + "&isCurr=false");
	}

}
