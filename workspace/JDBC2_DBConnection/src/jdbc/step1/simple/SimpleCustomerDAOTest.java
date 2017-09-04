package jdbc.step1.simple;

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

	public void insertCustomer() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("JDBC Simple DAO Test...");
	} // main

	
	
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
