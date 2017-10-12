package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;


public class DataSourceManager {
	private DataSource ds;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		try {
			Context ic = new InitialContext();
			System.out.println("[DataSourceManager] : Driver Loading...");
			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("[DataSourceManager] : DB Connecting...(DataSource LookUp)");
		} catch(Exception e) {
			System.out.println("WARNDING !! [DataSourceManager] : Something Went Wrong !...");
			e.printStackTrace();
		}
	}
	
	public static DataSourceManager getInstance() {
		return instance;
	}
	// ---------------------------------- for connection ----------------------------------//
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
}
