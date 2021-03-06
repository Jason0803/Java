package jdbc.test;

import java.sql.SQLException;

import config.DBConfig;
import jdbc.dao.MemberDAO;
import jdbc.exception.DuplicateIdException;
import jdbc.vo.Member;

public class MemberDAOTest {

	public static void main(String[] args) throws DuplicateIdException, SQLException {
		try {
			MemberDAO.getInstance().addMember(new Member("kosta", "IU", "1234", "신사동"));
		} catch (DuplicateIdException e) {
			e.getMessage();
		}

	}
	
	static {
		try {
			Class.forName(DBConfig.DRIVER);
			System.out.println("Driver Loaded !");
		} catch(ClassNotFoundException e) {
			System.out.println("Driver Not Loaded !");
		}
	
	}

}
