package jspbook.addrbook;

import java.sql.*;
import java.util.*;

/**
 * File : AddrBean.java
 * Desc : 주소록 프로그램 DAO 클래스
 * @author 황의정(dinfree@dinfree.com)
 */

public class AddrBean {
	
	//주소록 프로그램 DAO에 해당됩니다
	
	Connection conn=null; //DB연결 담당
	PreparedStatement pstmt=null; //SQL질의문 담당
	
	/* MySQL 연결정보 */
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/jspdb";
	
	//데이터베이스 연결 메서드
	void connect() {
		try {
			Class.forName(jdbc_driver);
			
			conn=DriverManager.getConnection(jdbc_url,"jspbook","1234");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//데이터베이스 연결 끊는 메서드
	void disconnect() {
		if(pstmt != null) { //SQL 실행문 먼저 끊는다
			try {
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
		if(conn !=null) { //DB연결 끊기
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	//수정된 주소록 내용 갱신을 위한 메서드, 주소를 추가하고난 뒤나 삭제하고난뒤 등 공통적으로 쓰이는 공용 메서드
	public boolean updateDB(AddrBook addrbook) {
		connect();
		
		String sql="update addrbook set ab_name=?, ab_email=?,ab_birth=?,ab_tel=?,ab_comdept=?,ab_memo=? where ab_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, addrbook.getAb_name());
			pstmt.setString(2, addrbook.getAb_email());
			pstmt.setString(3, addrbook.getAb_birth());
			pstmt.setString(4, addrbook.getAb_tel());
			pstmt.setString(5, addrbook.getAb_comdept());
			pstmt.setString(6, addrbook.getAb_memo());
			pstmt.setInt(7, addrbook.getAb_id());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	//주소목록중 특정 게시글 삭제하는 메서드
	public boolean deleteDB(int gb_id) {
		connect();
		String sql="delete from addrbook where ab_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);//SQL 실행문 객체 생성
			pstmt.setInt(1, gb_id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	//신규 주소록 메시지 추가 메서드
	public boolean insertDB(AddrBook addrbook) {
		connect();
		
		//sql문에서, gb_id는 인조키 이며 자동으로 등록되므로 입력하지 않는다
		String sql="insert into addrbook(ab_name,ab_email,ab_birth,ab_tel,ab_comdept,ab_memo)"
				+ "values(?,?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,addrbook.getAb_name());
			pstmt.setString(2,addrbook.getAb_email());
			pstmt.setString(3,addrbook.getAb_birth());
			pstmt.setString(4,addrbook.getAb_tel());
			pstmt.setString(5,addrbook.getAb_comdept());
			pstmt.setString(6,addrbook.getAb_memo());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		
		return true;
	}
	
}
