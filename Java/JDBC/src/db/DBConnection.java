package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	// static으로 설정함으로써 클래스마다 Connection 메소드를 설정할 필요가 없다.
	public static void initConnection() {	// Connection 초기화
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {	// Connection 연결
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "HR");
			System.out.println("DB Connection Seuccess!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;	// DB 접속정보를 출력
	}

}
