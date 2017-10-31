package model;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/*
 * 싱글톤 :: DAO/DataSourceManager/HandlerMapping
 * DataSource를 가져야함...DataSource를 필드에 선언/주입(JNDI 서비스)
 */
public class DataSourceManager {
 private DataSource ds;//선언
 
 private static DataSourceManager manager = new DataSourceManager();
 private DataSourceManager(){
	 try{
		 InitialContext ic = new InitialContext();
		 ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
		 System.out.println("DataSource 찾아옴....");
	 }catch(NamingException e){
		 e.printStackTrace();
	 }
 }
 public static DataSourceManager getInstance(){
	 return manager;
 }
 public DataSource getDataSource() {
	return ds;
 } 
}





