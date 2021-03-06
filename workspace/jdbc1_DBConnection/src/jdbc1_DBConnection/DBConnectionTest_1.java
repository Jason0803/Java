package jdbc1_DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest_1 {
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@192.168.30.128:1521:xe";
	public static final String USER = "hr";
	public static final String PASSWORD = "hr";
	
	public DBConnectionTest_1() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("Successful Driver Loading !!");
			
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB Connected !!");

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load DRIVER !");
		} catch (SQLException e) {
			System.out.println("Failed to connect DB !");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new DBConnectionTest_1();
	}

}
