package jdbc.step1.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBConfig;

/*
CREATE TABLE customer (
  name varchar2(20) PRIMARY KEY,
  age number(3),
  height number(3),
  weight number(3),
  gender char(5));
 
 */

public class SimpleCustomerDAOTest {
	
	// ---------------------------------- for connection ----------------------------------//
	public Connection connection() {
		Connection conn = null;
		try {
			conn = 
				DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
				// System.out.println("DB Connnected!");
		} catch (SQLException e) {
			System.out.println("DB Disconnected !");
		}
	
		return conn;
	}
	
	// ---------------------------------- for INSERT --------------------------------------//
	public void insertCustomer(String name, int age, int height, int weight, String gender) {
		/*
		 * DB Connection
		 * PreparedStatement (pre-comipile)
		 * bind
		 * executeUpdate
		 * close
		 */
		Connection conn = connection();
		System.out.println("INSERT Statement Creating...");
		try {
			
			PreparedStatement st_INSERT = 
					conn.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?)");
			
			st_INSERT.setString(1, name);
			st_INSERT.setInt(2, age);
			st_INSERT.setInt(3, height);
			st_INSERT.setInt(4, weight);
			st_INSERT.setString(5, gender);
			st_INSERT.executeUpdate();
			st_INSERT.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(" >> SQL Exception while INSERT !");
		}
		
		System.out.println("INSERT DONE for " + name);
	}
	
	// ---------------------------------- for DELETE --------------------------------------//
	public void deleteCustomer(String name) {
		Connection conn = connection();
		try {
			PreparedStatement st_DELETE =
					conn.prepareStatement("DELETE FROM customer WHERE name = ?");
			
			st_DELETE.setString(1, name);
			st_DELETE.executeUpdate();
			
			st_DELETE.close();
			conn.close();
			System.out.println("DELETE DONE for " + name);
		} catch (SQLException e) {
			System.out.println(" >> SQL Exception while DELETE !");
		}
	}
	// ---------------------------------- for UPDATE --------------------------------------//
	public void updateCustomer(String name, int age, int height, int weight, String gender) {
		Connection conn = connection();
		try {
			PreparedStatement st_UPDATE =
					conn.prepareStatement("UPDATE customer "
							+ "SET age = ?, height = ?, weight = ?, gender = ?"
							+ "WHERE name = ?");
			
				
			st_UPDATE.setInt(1, age);
			st_UPDATE.setInt(2, height);
			st_UPDATE.setInt(3, weight);
			st_UPDATE.setString(4, gender);
			st_UPDATE.setString(5, name);
				
			st_UPDATE.executeUpdate();
				
			st_UPDATE.close();
			conn.close();
			System.out.println("UPDATE DONE for " + name);
		} catch (SQLException e) {
			System.out.println(" >> SQL Exception while UPDATE !");
		}
	}
	// ------------------------------- for displayAll -----------------------------------//
	public void printAllCustomer() throws SQLException {
		Connection conn = connection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer");
		ResultSet rs = ps.executeQuery();
		
		System.out.println("\n[Display all Customers ...]");
		System.out.println("Name\tHeight\tWeight\tGender");
		while(rs.next()) {
			System.out.println(rs.getString("name") + "\t"
					+ rs.getInt("height") + "\t"
					+ rs.getInt("weight") + "\t"
					+ rs.getString("gender"));
			
		}
		
		ps.close();
		conn.close();
	}
	// ------------------------------- for display --------------------------------------//
	public void printCustomer(String name) throws SQLException {
		Connection conn = connection();
		PreparedStatement ps = 
				conn.prepareStatement("SELECT * FROM customer"
									+ "WHERE name = ?");
		
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		
		System.out.println("Display Customer : " + name);
		System.out.println("Name\tHeight\tWeight\tGender");
		
		if(rs.next()) {
			System.out.println(rs.getString("name") + "\t"
							+ rs.getInt("height") + "\t"
							+ rs.getInt("weight") + "\t"
							+ rs.getString("gender"));
		}
		
		ps.close();
		conn.close();
	}
	// ------------------------------------- MAIN -------------------------------------- //
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("JDBC Simple DAO Test...");
		SimpleCustomerDAOTest dao = new SimpleCustomerDAOTest();
		dao.insertCustomer("Jason", 24, 171, 63, "M");
		dao.insertCustomer("Gosling", 25, 173, 73, "M");
		dao.insertCustomer("Sunny", 28, 161, 53, "F");
		dao.deleteCustomer("Jason");
		dao.updateCustomer("Sunny", 29, 161, 54, "F");
		
		dao.printAllCustomer();
		dao.printCustomer("Sunny");
		
	} // main

	
	// ----------------------------------- for Drier ----------------------------------- //
	static {
		System.out.println("Driver Loading Start...");
		try {
			Class.forName(DBConfig.DRIVER);
			System.out.println("Driver Loading...");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		}
	}
}
