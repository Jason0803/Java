package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.jdbc.pool.DataSource;

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
	public Connection getConnection() throws SQLException {
		return DataSourceManager.getInstance().getConnection();
	}
	// ---------------------------------- for sequence 	 ----------------------------------//
	public int getCurrentSequence() throws SQLException {
		int currSeq = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()) currSeq = rs.getInt(1);
		} finally {
			closeAll(ps, conn, rs);
		}
		
		return currSeq;
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
	// ------------------------------- 	for getAllPosts 	 ----------------------------------//
	public ArrayList<BoardVO> getAllPosts() throws SQLException {
		ArrayList<BoardVO> list = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try {
			conn = getConnection();
			list = new ArrayList<BoardVO>();
			ps = conn.prepareStatement(StringQuery.PAGE_LIST);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new BoardVO(rs.getInt("no"), 
						rs.getString("title"), 
						rs.getString("writer"), 
						null, null,
						rs.getInt("hits"),
						rs.getString("time_posted"));
				
				list.add(vo);
				System.out.println("[BoardDao] : SELECT_ALL Query Result for VO #" + vo.getNo());
			}
		} finally {
			closeAll(ps, conn, rs);
		}
		return list;
	}

}
