package book.test;

import java.sql.SQLException;

import book.dao.BookDAO;
import book.exception.DuplicateIsbnException;
import book.exception.RecordNotFoundException;
import book.vo.Book;

public class BookDAOTest {

	public static void main(String[] args) {
		// dao = BookDAO.getInstance();
		try {
			String isbn = "4D4";
			// find 
			System.out.println(BookDAO.getInstance().doesExist(isbn));
			
			// resister
			BookDAO.getInstance().registerBook(new Book("6F6", "Mann", "Jason", "masan", 27000));
			
			// DELETE
			BookDAO.getInstance().deleteBook("6F6") ;

			// find - isbn
			System.out.println(BookDAO.getInstance().findBook("4D4").toString());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateIsbnException e) {
			System.out.println(e.getMessage());
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
