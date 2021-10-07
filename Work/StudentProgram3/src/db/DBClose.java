package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
	
	public static void close(Connection conn, Statement stmt) {	// insert, update에 들어있던 close를 따로 메소드로 만들어줌
		try {
			if(conn != null) { conn.close(); }
			if(stmt != null) { stmt.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void close(Connection conn, PreparedStatement psmt, ResultSet rs) {
		try {
			if(conn != null) { conn.close(); }
			if(psmt != null) { psmt.close(); }
			if(rs != null) { rs.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
