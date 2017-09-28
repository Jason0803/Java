package pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.model.MockDAO;
import pattern.model.NoteBook;

public class NoteBookProduct implements Product {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String model = request.getParameter("model");
		NoteBook noteBook = MockDAO.getInstance().findNoteBook(model);
		
		request.setAttribute("noteBook", noteBook);
		String path = "find_result.jsp";
		
		return path;
	}

}
