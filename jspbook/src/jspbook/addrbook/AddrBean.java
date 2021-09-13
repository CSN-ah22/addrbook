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
		if(pstmt != null) { //질의문담당 먼저 끊는다
			try {
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
		if(conn !=null) { //DB연결 담당 끊기
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
}
