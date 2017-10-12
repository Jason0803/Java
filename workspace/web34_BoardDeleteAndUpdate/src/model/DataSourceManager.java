package model;
/*
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataSourceManager {
	private DataSource ds;//수정
	
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		try {
			Context ic = new InitialContext();
			ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource Lookup....!!!!");
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	public static DataSourceManager getInstance() {
		return instance;		
	}	
	//수정
	public  Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}









