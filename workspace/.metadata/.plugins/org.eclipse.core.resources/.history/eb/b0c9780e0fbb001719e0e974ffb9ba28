package sql;
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
	private DataSource ds;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		try {
//			Class.forName(OracleInfo.DRIVER);
			Context ic = new InitialContext();
			System.out.println(">> Context create OK.");
//			conn = DriverManager.getConnection(OracleInfo.URL, OracleInfo.USER, OracleInfo.PASS);
			ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println(">> DataSource get OK.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
//		return conn;
		return ds.getConnection();
	}
}
