package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "HR");
			System.out.println("DB Connection Seuccess!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;	// DB 접속정보를 출력
	}
	
	public int insert(String id, String name, int age) {
		
		// 쿼리문 만들기
		// JDBC는 자바에서 받아온 데이터를 쿼리문을 통해 테이블에 삽입해주는 기능을 함
		String sql = " INSERT INTO USERDTO(ID, NAME, AGE, JOINDATE) "	// 문자열 안에서 엔터를 치면 다음줄로 이어짐
				+ " VALUES( '" + id + "', '" + name + "', " + age + ", SYSDATE) "; 	// 앞 뒤로 한칸씩 떼어놓는 게 좋음 + 문자열부분은 또 작은따옴표로 잡아주기
	
		Connection conn = getConnection();	// DB에 연결된 conn을 가져올 수 있음
		Statement stmt = null;
		
		int count = 0;	// insert 함수의 return이 될 값. 추가된 갯수에 따라 숫자가 변할것. 그때그때마다 count는 0에서부터 시작함 (로컬변수니까)
		
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
	
}
