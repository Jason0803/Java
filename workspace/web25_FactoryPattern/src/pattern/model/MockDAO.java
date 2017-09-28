package pattern.model;

import java.sql.SQLException;

public class MockDAO {
	private static MockDAO dao = new MockDAO();
	private MockDAO() {}
	public static MockDAO getInstance() {
		return dao;
	}
	
	public NoteBook findNoteBook(String model) throws SQLException {
		System.out.println(model);
		NoteBook nb = new NoteBook(model, 100);
		return nb;
	}
	
}
