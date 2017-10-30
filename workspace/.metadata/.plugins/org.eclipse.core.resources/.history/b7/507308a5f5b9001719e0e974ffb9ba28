package model.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jdbc.exception.DuplicateIdException;
import jdbc.exception.RecordNotFoundException;
import model.vo.member.Member;
import sql.StringQuery;


public class MemberDAO {
	// ---------------------------- Sigleton  ----------------------------- //
	private static MemberDAO dao = new MemberDAO();
	private DataSource ds;
	
	private MemberDAO() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource..LookUp Success !");
			
		} catch (NamingException e) {
			System.out.println("DataSource..LookUp Fail :( ");
			e.printStackTrace();
		}
	}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	// ---------------------------------- for connection ----------------------------------//
	public Connection connection() throws SQLException {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			System.out.println("Hello, DB Connected w/ DataSource ");
		} catch (SQLException e) {
			System.out.println("DB Disconnected !");
		}
	
		return conn;
	}
	// ---------------------------------- for close ----------------------------------//
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null && conn !=null){
			ps.close();
			conn.close();
		} else {
			System.out.println("ERROR ! Exception caught on [MemberDAO]@closeAll(ps,conn)");
			return;
		}
	}
	public void closeAll(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException {
		if( ps!=null && conn != null && rs != null) {
			rs.close();
			closeAll(ps, conn);
		} else {
			System.out.println("ERROR ! Exception caught on [MemberDAO]@closeAll(ps,conn,rs)");
			return;	
		}
	}
	
	// ---------------------------------- for INSERT ---------------------------------- //
	public Member registerMember(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		Member returnMember = member;
		
		try {
			conn = connection();
				
			if( !doesExist(member.getId(), conn) ){
				conn = connection();
				System.out.println("connection");
						
				ps = conn.prepareStatement(StringQuery.REGISTER_MEMBER);
				System.out.println("[MemberDAO]@registerMember Executed !");
				
				ps.setString(1, member.getId());
				ps.setString(2, member.getPassword());
				ps.setString(3, member.getName());
				ps.setInt(4, member.getAccountPlan());
				ps.setInt(5, member.getTheme());
				
				ps.executeUpdate();
				
				System.out.println("[MemberDAO]@registerMember : Adding member done");
			} else  {
				return null;
			}
		} finally {
			try{
				closeAll(ps, conn);
			} catch(SQLException e) {
				System.out.println("[MemberDAO]@registerMember : SQLException Catched !");
				e.printStackTrace();
			}
		}
		returnMember.setPassword(null);
		
		return returnMember;
	}
			
	// ---------------------------------- for Search ---------------------------------- //
	public boolean doesExist(String id, Connection conn) throws SQLException {
		PreparedStatement ps = 
				conn.prepareStatement(StringQuery.ISEXIST_MEMBER);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();

		return rs.next();
	}
	public boolean doesExist(String id) throws SQLException {
		Connection conn = connection();
		PreparedStatement ps = 
				conn.prepareStatement(StringQuery.ISEXIST_MEMBER);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();

		return  rs.next();
	}
	
	public boolean checkPasswordValidation(String id, String password, Connection conn) throws SQLException, RecordNotFoundException{
		PreparedStatement ps = 
				conn.prepareStatement(StringQuery.CHECK_VALIDATION);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() ) {
			if(password.equals(rs.getString("password") )) {
				// When input and internal password matching
				return true;
			} else return false; // Password NOT matching
		}else {
			// input id does not exist in DB
			throw new RecordNotFoundException("[MemberDAO]@checkPasswordValidation : No Such User Found !");
		}
	}
	// ---------------------------------- for UPDATE ---------------------------------- //
	public Member updateMember(Member member, String password) throws SQLException, DuplicateIdException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
				
		try {
			conn = connection();
			if(checkPasswordValidation(member.getId(), member.getPassword(), conn)) {
				// #00035 : Check validation (password)
				ps = conn.prepareStatement(StringQuery.UPDATE_MEMBER);
				ps.setString(1, password);
				ps.setString(2, member.getName());
				ps.setInt(3, member.getAccountPlan());
				ps.setInt(4, member.getTheme());
				ps.setString(5, member.getId());
				
				int result = ps.executeUpdate();
				
				System.out.println("[MemberDAO]@updateMember : updating member done");
			}else {
				System.out.println("Incorrect Password !");
				return null;
			}
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			closeAll(ps, conn, rs);
		}
		
		return member;
	}
	
	// ---------------------------------- for Login ---------------------------------- //
	public Member login(String id, String password) throws SQLException{
		Member member = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = connection();
			if(checkPasswordValidation(id, password, conn)) {
				ps = conn.prepareStatement(StringQuery.FIND_MEMBER_BY_ID);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()) {
					member = new Member(id, null, rs.getString("name"), rs.getInt("acc_plan"), rs.getInt("theme"));
				}
			} 
		}catch(RecordNotFoundException e){
			return null;
		}finally {
			closeAll(ps, conn, rs);
		}
		
		return member;
	}
	
	public Member findMemberById(String id) throws SQLException, RecordNotFoundException {
		Member member = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = connection();

			ps = conn.prepareStatement(StringQuery.FIND_MEMBER_BY_ID);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				member = new Member(id, rs.getString("password"), rs.getString("name"), rs.getInt("acc_plan"), rs.getInt("theme"));
			}

		}finally {
			try{
				closeAll(ps, conn, rs);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return member;
	}
}
