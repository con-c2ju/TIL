package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;

public class UpdateTest {

	public int update(String name, int age, String id) {
		
		String sql = " UPDATE USERDTO "
				+ " SET NAME =  '" + name + "', AGE = " + age + " "
						+ " WHERE ID = '" + id + "' ";
		
		Connection conn = DBConnection.getConnection();	// static으로 설정해서 이렇게 사용할 수 있다.
		Statement stmt = null;
		
		int count = 0;
		
		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, stmt);
		}
		
		return count;
		
	}
	
	/*
	내가만든거
	
	public int updateNameAge(String oname, String name, int age) {
		String sql = " UPDATE USERDTO "
				+ " SET name = '" + name + "', age =" + age + " "
						+ "WHERE name = '" + oname + "' ";
		
		Connection conn = getConnection();
		Statement stmt = null;
		
		int count = 0;
		
		try {
			stmt = conn.createStatement();	// stmt가 Connection 정보를 파악
			
			count = stmt.executeUpdate(sql);	// sql구문을 실행해서 Update해라. 쿼리가 실제로 실행되는 시점.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	// conn과 stmt를 닫아줘야함. DB는 잠깐 문열고 데이터주고받고 문닫고 해야함.
				try {
					if(stmt != null) { stmt.close(); }
					if(conn != null) { conn.close(); }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		return count;
		
	}
	*/
}
