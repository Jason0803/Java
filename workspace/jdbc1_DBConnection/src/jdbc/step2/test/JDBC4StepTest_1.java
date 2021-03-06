package jdbc.step2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC4StepTest_1 {
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@192.168.30.131:1521:xe";
	public static final String USER = "hr";
	public static final String PASSWORD = "hr";
	
	public JDBC4StepTest_1() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("Driver Loaded Successfully !");
			
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB Connnected!");
			
			Statement st = conn.createStatement();//
			System.out.println("Statement Creating...");
			
			String query_1 = "INSERT INTO member VALUES(24, '1', 'kosta')";
			st.executeUpdate(query_1);
			
			String query_3 = "SELECT * FROM member";
			ResultSet rs = st.executeQuery(query_3);
			
			
			while(rs.next()) {
				System.out.println(rs.getInt("ssn") + " "
									+ rs.getString("name") + " " 
									+ rs.getString("address") );
								
			}

			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Failed !");
		} catch (SQLException e) {
			System.out.println("DB Connection Failed !");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new JDBC4StepTest_1();
	}

}
