package jdbc.step2.dao;
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
import jdbc.step2.vo.Member;

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
			conn = 
				DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
				// System.out.println("DB Connnected!");
		} catch (SQLException e) {
			System.out.println("DB Disconnected !");
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
	// ---------------------------------- for INSERT ----------------------------------//
	public void addMember(Member member) throws SQLException{
		Connection conn = connection();
		PreparedStatement ps = 
				conn.prepareStatement("INSERT INTO member VALUES(?,?,?,?)");
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPassword());
		ps.setString(4, member.getAddress());
		
		ps.executeUpdate();
		closeAll(ps, conn);
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
									+ "SET id = ?, name = ?, password = ?, address = ?"
									+ "WHERE id = ?");
		
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
			result.add(new Member(rs.getString("id"), rs.getString("name"), rs.getString("password"), rs.getString("address")));
		}
			
		return result;
	}
	
	
}
