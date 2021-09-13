package jspbook.addrbook;

import java.sql.*;
import java.util.*;

/**
 * File : AddrBean.java
 * Desc : �ּҷ� ���α׷� DAO Ŭ����
 * @author Ȳ����(dinfree@dinfree.com)
 */

public class AddrBean {
	
	//�ּҷ� ���α׷� DAO�� �ش�˴ϴ�
	
	Connection conn=null; //DB���� ���
	PreparedStatement pstmt=null; //SQL���ǹ� ���
	
	/* MySQL �������� */
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/jspdb";
	
	//�����ͺ��̽� ���� �޼���
	void connect() {
		try {
			Class.forName(jdbc_driver);
			
			conn=DriverManager.getConnection(jdbc_url,"jspbook","1234");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//�����ͺ��̽� ���� ���� �޼���
	void disconnect() {
		if(pstmt != null) { //���ǹ���� ���� ���´�
			try {
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
		if(conn !=null) { //DB���� ��� ����
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
}
