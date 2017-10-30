package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.ModelAndView;
import model.dao.diary.DiaryDAO;
import model.vo.diary.Diary;
import model.vo.diary.Schedule;
import model.vo.member.Member;
import util.CocoaDate;

public class DeleteDiaryController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mvo = (Member)request.getSession().getAttribute("memberVO");
		CocoaDate today = new CocoaDate();
		int no = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("no", no);
		int deleteResult = DiaryDAO.getInstance().deleteDiary(no);
		String path = null;
		switch(deleteResult) {
			case Diary.MEMO : {
				path = "DispatcherServlet?command=memoList";
				break;
			}
			default : {
				path = "DispatcherServlet?command=cal&year="+today.getYear()+"&month="+today.getMonth();
				break;
			}
		}
		
		return new ModelAndView(path);
	}

}


