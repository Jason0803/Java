package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO dao=new MemberDAO();
	private DataSource ds;//선언했다고 해서 주입되는것은 아니다...반드시 주입이 일어나야한다
	private MemberDAO(){
		try{
			Context ic = new InitialContext();
			ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource.....Lookup....!!");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	public static MemberDAO getInstance(){
		return dao;
	}
	private Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	//
	public ArrayList<String> getAllIdList()throws SQLException{
		ArrayList<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			ps = conn.prepareStatement("SELECT id FROM member2");
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString(1));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;		
	}



 	public void updateMember(MemberVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="update member2 set password=?,name=?,address=? where id=?";
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1,vo.getPassword());
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getAddress());
			pstmt.setString(4,vo.getId());
			int result=pstmt.executeUpdate();
			System.out.println("update ok.."+result);
		}finally{
			closeAll(pstmt,con);
		}
	}
	public void registerMember(MemberVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="insert into member values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4,vo.getAddress());
			int result=pstmt.executeUpdate();
			System.out.println("insert ok.."+result);
		}finally{
			closeAll(pstmt,con);
		}
	}
	public MemberVO findMemberById(String id) throws SQLException{
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select password,name,address from member2 where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo=new MemberVO(id,rs.getString(1),rs.getString(2),rs.getString(3));
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return vo;
	}
	public ArrayList<MemberVO> findByAddress(String address) throws SQLException{
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select id,name from member2 where address=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,address);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new MemberVO(rs.getString(1),null,
						rs.getString(2),address));
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	public MemberVO login(String id,String password) throws SQLException{
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql=
		   "select name,address from member2 where id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo=new MemberVO(id,password,rs.getString(1),rs.getString(2));
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return vo;
	}
	public ArrayList<MemberVO> getAllMember() throws SQLException{
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select * from member2";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new MemberVO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4)));
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	
	//true가 리턴되면 해당 id값이 이미 디비에 저장되어 있음을 의미
	//따라서 true일 때는 id중복... 그 아이디를 사용할 수 없도록 유도..checkId()자바스크립트에서 처리
	public boolean isExist(String id) throws SQLException{
		boolean result=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			String sql="select count(*) from member2 where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){				
				if(rs.getInt(1)>0)
					result=true;
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return result;
	}
}

















