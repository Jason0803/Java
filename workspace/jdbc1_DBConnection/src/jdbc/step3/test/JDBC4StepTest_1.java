package jdbc.step3.test;
/*

CREATE TABLE member (
	id varchar2(20) PRIMARY KEY,
	name varchar2(30) NOT NULL,
	pass varchar2(30) NOT NULL,
	tel varchar(30) NOT NULL);

1) 컬럼명 추가	:	ALTER TABLE member ADD(address varchar2(10));
2) 컬럼속성변경	:	ALTER TABLE member MODIFY(address varchar2(50));
3) 컬럼이름변경	:	ALTER TABLE member RENAME COLUMN pass TO password;
4) 컬럼명삭제	:	ALTER TABLE member DROP COLUMN tel;

 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import config.DBConfig;

public class JDBC4StepTest_1 {

	public JDBC4StepTest_1() {
		Scanner sc = new Scanner(System.in);
		
		try {
			// --------------------------- 	DB Connection	 --------------------------- //
			Class.forName(DBConfig.DRIVER);
			System.out.println("Driver Loaded Successfully !");
			
			Connection conn = 
					DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
			System.out.println("DB Connnected!");
			
			// --------------------------- 	Column info.	 --------------------------- //

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM member");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			String[] column = new String[numberOfColumns+1];
			
			//boolean b = rsmd.isSearchable(1);
			
			for(int i =1; i <= numberOfColumns; i++) {
				column[i] = rsmd.getColumnName(i);
			}
			
			PreparedStatement st_INSERT = 
					conn.prepareStatement("INSERT INTO member VALUES(?,?,?,?)");
			

			// --------------------------- Input From Console --------------------------- //

			System.out.println("INSERT Statement Creating...");
			System.out.print("How many rows to be created ? : ");
			int rows = sc.nextInt();
			String input;
			for(int i = 0; i < rows; i++) {
				for(int j = 1; i < numberOfColumns; j++) {
					if(j == column.length) break;;
					System.out.print("\n" + column[j] + " : ");
					input = sc.next();
					
					st_INSERT.setString(j, input);
				}
				st_INSERT.executeUpdate();
			}
			// -------------------------- Close opened ones -------------------------- //
			st_INSERT.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Failed !");
		} catch (SQLException e) {
			System.out.println("DB Connection Failed !");
		} 
	}
	public static void main(String[] args) {
		new JDBC4StepTest_1();
	}

}
