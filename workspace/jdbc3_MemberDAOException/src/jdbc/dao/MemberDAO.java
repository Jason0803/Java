package jdbc.dao;
/*
 * DAO = Database Access Object
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBConfig;
import jdbc.exception.DuplicateIdException;
import jdbc.vo.Member;



public class MemberDAO {
	// ---------------------------------- for singleton  ----------------------------------//
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		
	}
	public static MemberDAO getInstance() {
		return dao;
	}
	// ---------------------------------- for connection ----------------------------------//
	public Connection connection() {
		Connection conn = null;
		try {
			Class.forName(DBConfig.DRIVER);
			conn = 
				DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
				// System.out.println("DB Connnected!");
		} catch (SQLException e) {
			System.out.println("DB Disconnected !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return conn;
	}
	// ---------------------------------- for close ----------------------------------//
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	// ---------------------------------- for Search ---------------------------------- //
	public boolean doesExist(String id, Connection conn) throws SQLException {
		//Connection conn = connection();
		PreparedStatement ps = 
				conn.prepareStatement("SELECT id FROM member"
									+ "WHERE id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();

		return rs.next();
	}
	
	// ---------------------------------- for INSERT ---------------------------------- //
	public void addMember(Member member) throws SQLException, DuplicateIdException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = connection();
			if( !doesExist(member.getId(), conn) ){
				conn = connection();
				ps = conn.prepareStatement("INSERT INTO member VALUES(?,?,?,?)");
				
				ps.setString(1, member.getId());
				ps.setString(2, member.getName());
				ps.setString(3, member.getPassword());
				ps.setString(4, member.getAddress());
				
				ps.executeUpdate();
			} else throw new DuplicateIdException("Already Existing ID !");
		} finally {
			closeAll(ps, conn);
		}
		
	}
	// ---------------------------------- for DELETE  ----------------------------------//
		public void delelteMember(Member member) throws SQLException{
			Connection conn = connection();;
			PreparedStatement ps = 
					conn.prepareStatement("DELETE FROM member"
										+ "WHERE id = ?");
			
			ps.setString(1, member.getId());
			ps.executeUpdate();
			closeAll(ps, conn);
		}
	// ---------------------------------- for UPDATE ----------------------------------//
	public void updateMember(Member member) throws SQLException{
		Connection conn = connection();
		PreparedStatement ps =
				conn.prepareStatement("UPDATE FROM member"
									+ " SET id = ?, name = ?, password = ?, address = ?"
									+ " WHERE id = ?");
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPassword());
		ps.setString(4, member.getAddress());
		ps.setString(5, member.getId());
		
		ps.executeUpdate();
		closeAll(ps, conn);
			
	}
	// ---------------------------------- for SELECT  ----------------------------------//
	public Member getMember(String id) throws SQLException{
		Member result = null;
		Connection conn = connection();
		PreparedStatement ps =
				conn.prepareStatement("SELECT FROM member"
								+ "WHERE id = ?");
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			result.setId(rs.getString("id"));
			result.setName(rs.getString("name"));
			result.setPassword(rs.getString("address"));
			result.setAddress(rs.getString("address"));
		}
		
		return result;
	}
	// ---------------------------------- for SELECT  ----------------------------------//
	public ArrayList<Member> getAllMember() throws SQLException{
		ArrayList<Member> result = null;
		Connection conn = connection();
		PreparedStatement ps = 
				conn.prepareStatement("SELECT * FROM member");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			result.add(new Member(rs.getString("id"), rs.getString("name"), 
					rs.getString("password"), rs.getString("address")));
		}
			
		return result;
	}
	
	
}
