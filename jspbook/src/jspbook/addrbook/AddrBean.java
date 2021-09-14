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
		if(pstmt != null) { //SQL ���๮ ���� ���´�
			try {
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
		if(conn !=null) { //DB���� ����
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	//������ �ּҷ� ���� ������ ���� �޼���, �ּҸ� �߰��ϰ� �ڳ� �����ϰ��� �� ���������� ���̴� ���� �޼���
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
	//�ּҸ���� Ư�� �Խñ� �����ϴ� �޼���
	public boolean deleteDB(int gb_id) {
		connect();
		String sql="delete from addrbook where ab_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);//SQL ���๮ ��ü ����
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
	//�ű� �ּҷ� �޽��� �߰� �޼���
	public boolean insertDB(AddrBook addrbook) {
		connect();
		
		//sql������, gb_id�� ����Ű �̸� �ڵ����� ��ϵǹǷ� �Է����� �ʴ´�
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
