package book.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.exception.DuplicateIsbnException;
import book.exception.InvalidInputException;
import book.exception.RecordNotFoundException;
import book.vo.Book;
import config.DBConfig;

public class BookDAO {
	private static BookDAO dao = new BookDAO();
	private BookDAO () { 
		try {
			Class.forName(DBConfig.DRIVER);
			System.out.println("Driver Successfully Loaded !");
			
		} catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Failed !");
		}
	}
	
	public static BookDAO getInstance() {
		return dao;
	}
	
	public Connection connection() throws SQLException {
		return DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}
	
	// ---------------------------------- Exist  ---------------------------------- //
	public int doesExist(String isbn) throws SQLException {
		int count = 0;
		Connection conn = connection();
		PreparedStatement ps = 
				conn.prepareStatement("SELECT title FROM book "
									+ "WHERE isbn = ?");
		ps.setString(1, isbn);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) count++;
		closeAll(rs, ps, conn);
		return count;
	}
	
	// ---------------------------------- Resister ---------------------------------- //
	public void registerBook(Book vo) throws SQLException, DuplicateIsbnException {
		Connection conn = connection();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO book VALUES (?,?,?,?,?)");
		
		if(doesExist(vo.getIsbn()) == 1) throw new DuplicateIsbnException("Existing Book !");
		
		try {
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getWriter());
			ps.setString(4, vo.getPublisher());
			ps.setInt(5, vo.getPrice());
			
			ps.executeUpdate();
			System.out.println("The book " + vo.getTitle() + " has been successfully Resistered !");
		} finally {
			closeAll(ps, conn);
		}
	}
	
	// ---------------------------------- Delete  ---------------------------------- //
	public void deleteBook(String isbn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
				
		try {
			System.out.println("DELETE READEY ...");
			conn = connection();
			ps = conn.prepareStatement("DELETE FROM book WHERE isbn = ?");

			ps.setString(1, isbn);
			int row = ps.executeUpdate();
			
			if(row == 0) throw new RecordNotFoundException("NO Book Found !");
			System.out.println("Book " + isbn + " Has been successfully removed !");
		} finally {
			closeAll(ps, conn);
		}
	}
	
	// ---------------------------------- Find ISBN  ---------------------------------- //
	public Book findBook(String isbn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
				
		ResultSet rs = null;
		Book book = null;

		
		try {
			conn = connection();
			ps = conn.prepareStatement("SELECT * FROM book "
					+ "WHERE isbn = ?");
			ps.setString(1, isbn);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5));
				
			} else throw new RecordNotFoundException("No such Book Found !");
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return book;
	}
	
	// ---------------------------------- Find Title ---------------------------------- //
	public Book findBook(String title, String isbn) throws SQLException {
		Connection conn = connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		
		try {
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return book;
	}
	
	// ---------------------------------- Find Price ---------------------------------- //
	public ArrayList<Book> findBook(int min, int max) throws SQLException, InvalidInputException {
		Connection conn = connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> book = null;
		
		try {
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return book;
	}
	
	// ---------------------------------- Find Writer ---------------------------------- //
	public ArrayList<Book> findByWriter(String writer) throws SQLException {
		Connection conn = connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> book = null;
		
		try {
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return book;
	}
	
	public void discountBook(int per, String publisher) throws SQLException, InvalidInputException {
		Connection conn = connection();
		PreparedStatement ps = null;

		ArrayList<Book> book = null;
		
		try {
			
		} finally {
			closeAll(ps, conn);
		}
	}
	
	public void printAllBookInfo() throws SQLException {
		Connection conn = connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> book = null;
		
		try {
			
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	
}
