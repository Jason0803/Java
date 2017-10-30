package controller;

import java.util.Vector;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.transport.nio.ParallelNioSender;

import controller.util.ModelAndView;
import dao.diary.DiaryDAO;
import sun.security.jca.GetInstance;
import util.CocoaDate;
import vo.diary.Diary;
import vo.diary.Memo;
import vo.diary.Note;
import vo.member.Member;

public class NoteViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Member mvo = (Member)request.getSession().getAttribute("memberVO");
		String id = mvo.getId();
		boolean isCurr = Boolean.parseBoolean(request.getParameter("isCurr"));
		Vector<Note> notes=DiaryDAO.getInstance().getAllNote(id);
		Note note=null;
		
		request.setAttribute("notes", notes);
		if(isCurr) {
			int no=DiaryDAO.getInstance().getCurrNoteNo();
			note=DiaryDAO.getInstance().getNoteByNo(no);
		}else if(!isCurr) {
			note=DiaryDAO.getInstance().getNoteByNo(Integer.parseInt(request.getParameter("diaryNo")));
		} else {
			// Type Exception
			System.out.println("[NoteViewController] : NULL for 'isCurr' entered !");
			System.out.println(" - Current value for isCurr : " + isCurr);
		}
		request.setAttribute("note", note);
		
		return new ModelAndView("note_view.jsp");
	}

}
