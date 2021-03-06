package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql.StringQuery;

public class BoardDao {
	// ---------- for Singleton Pattern ---------- //
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return dao;
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
	// ---------------------------------- for connection ----------------------------------//
	public Connection getConnection() {
		return DataSourceManager.getInstance().getConnection();
	}
	// ---------------------------------- for posting 	 ----------------------------------//	
	public void posting(BoardVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_POSTING);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getPassword());
			ps.setString(4, vo.getContent());
			
			System.out.println("Current Sequence No : " + vo.getNo());
			int row = ps.executeUpdate();
			System.out.println("[BoardDao] : INSERT Query Result : " + row);
			
			ps = conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()) vo.setNo(rs.getInt(1));
			
			System.out.println("Current Sequence No : " + vo.getNo());
		} finally {
			closeAll(ps, conn);
		}
	}
	// ------------------------------- 	for getPosting 	 ----------------------------------//
	public BoardVO getPostingByNo(int no) throws SQLException {
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_POSTING);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO(no, rs.getString("title"), rs.getString("writer"), rs.getString("content"), rs.getInt("hits"), rs.getString("time_posted"));
			}
			System.out.println("[BoardDao] : SELECT Query Result for : " + no);
			
		}finally {
			closeAll(ps, conn, rs);
		}
		return vo;
	}
}
