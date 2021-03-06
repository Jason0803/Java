package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.DBConfig;

public class Database {
	// -------------------------------------- Connection	-------------------------------------- //
	public Database(String server) throws ClassNotFoundException {
		Class.forName(DBConfig.DRIVER);
		
	}
	
	public Connection getConnect() throws SQLException {
		Connection conn = 
				DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
		
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	// -------------------------------------- BusnessLogic	-------------------------------------- //
	// --------------------------------- 	isExist		--------------------------------- //
	public boolean isExists(Connection conn, String ssn) throws SQLException {
		PreparedStatement ps = 
				conn.prepareStatement("SELECT * FROM customer "
									+ "WHERE ssn = ?");
		ps.setString(1, ssn);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	// --------------------------------- addCustomer	--------------------------------- //
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null; 
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(isExists(conn, cust.getSsn())) throw new DuplicateSSNException("Existing Customer !");
			
			ps = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?)");
			ps.setString(1, cust.getSsn());
			ps.setString(2, cust.getName());
			ps.setString(3, cust.getAddress());
			ps.executeUpdate();
			
		} finally {
			closeAll(ps, conn);
		}
	}
	// --------------------------------- deleteCustomer	--------------------------------- //
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(!isExists(conn, ssn)) throw new RecordNotFoundException("No Such Customer Found !");
			
			ps = conn.prepareStatement("DELETE FROM customer WHERE ssn = ?");
			ps.setString(1, ssn);
			ps.executeUpdate();
			
		} finally {
			closeAll(ps, conn);
		}
	}
	// --------------------------------- updateCustomer	--------------------------------- //
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(!isExists(conn, cust.getSsn())) throw new RecordNotFoundException("No Such Customer Found !");
			
			ps = conn.prepareStatement("UPDATE FROM customer SET ssn = ?, cust_name = ?, address= ? "
									+ "WHERE ssn = ?");
			ps.setString(1, cust.getSsn());
			ps.setString(2, cust.getName());
			ps.setString(3, cust.getAddress());
			ps.setString(4,	cust.getSsn());
			
			ps.executeUpdate();
			
		} finally {
			closeAll(ps, conn);
		}
	}
	// --------------------------------- getPortfolio	--------------------------------- //
	public Vector<SharesRec> getPortfolio(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<SharesRec> v = new Vector<SharesRec>();
		try {
			conn = getConnect();
			if(!isExists(conn, ssn)) throw new RecordNotFoundException("No Such Customer Found !");
			
			ps = conn.prepareStatement("SELECT * FROM shares "
									+ "WHERE ssn = ?");
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			while(rs.next()) {
				v.add(new SharesRec(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
			
		} finally {
			closeAll(rs,ps,conn);
		}
		
		
		return v;
	}
	// --------------------------------- getCustomer	--------------------------------- //
	public CustomerRec getCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec cr = null;
		try {
			conn = getConnect();
			// if(!isExists(conn, ssn)) throw new RecordNotFoundException("No Such Customer Found !");
			
			ps = conn.prepareStatement("SELECT * FROM customer "
									+ "WHERE ssn = ?");
			ps.setString(1, ssn);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				cr = new CustomerRec(rs.getString(1), rs.getString(2), rs.getString(3), getPortfolio(ssn));
			} else throw new RecordNotFoundException("No Such Customer Found !");
			
		} finally {
			closeAll(rs,ps,conn);
		}
		
		return cr;
	}
	// --------------------------------- getAllCust.	--------------------------------- //
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustomerRec> list = null;
		try {
			conn = getConnect();
			// if(!isExists(conn, ssn)) throw new RecordNotFoundException("No Such Customer Found !");
			
			ps = conn.prepareStatement("SELECT * FROM customer");
			rs = ps.executeQuery();
			list = new ArrayList<CustomerRec>();
			
			while(rs.next()) {
				list.add(new CustomerRec(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			closeAll(rs,ps,conn);
		}
		
		return list;
	}
	// --------------------------------- getAllStock.	--------------------------------- //
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StockRec> list = null;
		try {
			conn = getConnect();
			// if(!isExists(conn, ssn)) throw new RecordNotFoundException("No Such Customer Found !");
			
			ps = conn.prepareStatement("SELECT * FROM stock");
			rs = ps.executeQuery();
			list = new ArrayList<StockRec>();
			
			while(rs.next()) {
				list.add(new StockRec(rs.getString(1), rs.getFloat(2)));
			}
			
		} finally {
			closeAll(rs,ps,conn);
		}
		
		return list;
	}
	// --------------------------------- getStockpPr.	--------------------------------- //
	public float getStockPrice(String symbol) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		float price = 0.0f;
		try {
			conn = getConnect();
			ps = conn.prepareStatement("SELECT price FROM stock "
									+ "WHERE symbol = ?");
			ps.setString(1, symbol);
			rs = ps.executeQuery();
			if(rs.next()) price = rs.getFloat(1);
			else throw new RecordNotFoundException("No Such Stock Existing !");
			
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return price;
	}
	// --------------------------------- buyStocks.		--------------------------------- //
	@SuppressWarnings("resource")
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			ps = conn.prepareStatement("SELECT * FROM shares WHERE ssn = ? AND symbol = ?");
			ps.setString(1, ssn);
			ps.setString(2, symbol);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(3) == 0) {
					ps = conn.prepareStatement("INSERT INTO shares VALUES(?,?,?)");
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					ps.setInt(3, quantity);
					ps.executeUpdate();
				} else {
					ps = conn.prepareStatement("UPDATE shares SET ssn = ?, symbol = ?, quantity = quantity + ? "
												+ "WHERE ssn = ? AND symbol = ?");
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					ps.setInt(3, quantity);
					ps.setString(4, ssn);
					ps.setString(5, symbol);
					ps.executeUpdate();
				}
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
	}
	
	// --------------------------------- sellStocks.	--------------------------------- //
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException, InvalidTransactionException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		conn = getConnect();
		String query ="SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		ps.setString(2, symbol);
		rs = ps.executeQuery();
		if(rs.next()) {
		int q = rs.getInt(1);//현재보유주식
		//int newQuantity=q-quantity;
		if(q==quantity) { //delete
		String query1 = "DELETE FROM shares WHERE ssn=? AND symbol=?";
		ps = conn.prepareStatement(query1);
		ps.setString(1, ssn);
		ps.setString(2, symbol);
		System.out.println(ps.executeUpdate()+" sellShares..delete");
		}else if(q>quantity) { //update
		String query2="UPDATE shares SET quantity= quantity-? WHERE ssn=? AND symbol=?";
		ps = conn.prepareStatement(query2);
		ps.setInt(1, quantity);
		ps.setString(2, ssn);
		ps.setString(3, symbol);
		System.out.println(ps.executeUpdate()+" sellShares... update");
		}else {
		throw new InvalidTransactionException("팔려는 주식이 넘 많아요");
		}

		}else {
		throw new RecordNotFoundException("팔고자 하는 주식 없음!!");
		}
		}finally {
		closeAll(rs, ps, conn);
		}
	}
	// --------------------------------------	 	-------------------------------------- //	
}
