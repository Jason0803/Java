package jdbc.step2.test;

import java.sql.SQLException;

import config.DBConfig;
import jdbc.step2.dao.MemberDAO;
import jdbc.step2.vo.Member;

public class MemberDAOTest {

	public static void main(String[] args) {
		try {
			MemberDAO.getInstance().addMember(new Member("kosta", "IU", "1234", "신사동"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
