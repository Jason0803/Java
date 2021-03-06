package jdbc.step3.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC4StepTest_2 {
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@192.168.30.131:1521:xe";
	public static final String USER = "hr";
	public static final String PASSWORD = "hr";
	
	public JDBC4StepTest_2() {
		try {
			Class.forName(DRIVER_NAME);
			
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Driver Connected !");
			
			System.out.println("Query...");
			Statement st = conn.createStatement();
			String[] queries ={
					"INSERT INTO member values('oracle', 'oracle', 50)",
					"INSERT INTO member values('jdk', 'james', 60)",
					"DELETE FROM member WHERE dept='oracle'",
					"UPDATE member SET name = 'zeus', age = 62 WHERE dept = 'jdk' ",
					"SELECT * FROM member"
			};
			
			System.out.println("Execute Queries...");
			
			for(int i = 0; i < 4; i++) {
				st.executeUpdate(queries[i]);
			}
			
			
			// System.out.println("hi");
			ResultSet rs = st.executeQuery(queries[4]);
			
			while(rs.next()) {
				System.out.println(rs.getString("dept") + " "
									+ rs.getString("name") + " "
									+ rs.getInt("age"));
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Failed !");
		} catch (SQLException e) {
			System.out.println("DB Connection Failed !");
		}
	}
	public static void main(String[] args) {
		new JDBC4StepTest_2();

	}

}
