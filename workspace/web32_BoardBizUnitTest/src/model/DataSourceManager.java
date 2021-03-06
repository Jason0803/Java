package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBConfig;

public class DataSourceManager {
	private Connection conn;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		try {
			Class.forName(DBConfig.DRIVER);
			System.out.println("[DataSourceManager] : Driver Loading...");
			
			conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
			System.out.println("[DataSourceManager] : DB Connecting...");
		} catch(Exception e) {
			System.out.println("WARNDING !! [DataSourceManager] : Something Went Wrong !...");
			e.printStackTrace();
		}
	}
	
	public static DataSourceManager getInstance() {
		return instance;
	}
	// ---------------------------------- for connection ----------------------------------//
	public Connection getConnection() {
		return conn;
	}
	
}
