package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DBClose;
import db.DBConnection;
import dto.StudentDto;

public class StudentDao {
	
	Scanner scan = new Scanner(System.in);
	
	public StudentDao() {
		DBConnection.initConnection();
		// 메인에 추가해도 되지만, 직접 DB와 교류하는 건 Dao이기 때문에 여기 생성하는 게 좋음
		// 어차피 메인에서도 Dao 생성자 만들때 같이 실행됨
	}
	
	public void Create() {
		
		System.out.print("학생이름 = ");
		String name = scan.next();
		
		System.out.print("국어 = ");
		int kor = scan.nextInt();
		
		System.out.print("영어 = ");
		int eng = scan.nextInt();
		
		System.out.print("수학 = ");
		int math = scan.nextInt();
		
		// insert
		String sql = " INSERT INTO STUDENT(NUM, NAME, KOR, ENG, MATH) "
				   + " VALUES(STUSEQ.NEXTVAL, ?, ?, ?, ?) ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, kor);
			psmt.setInt(3, eng);
			psmt.setInt(4, math);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		if(count > 0) {
			System.out.println("추가되었습니다.");
		} else { System.out.println("추가되지 않았습니다."); }
	}
	
	
	public void Delete() {
		System.out.print("정보를 삭제할 학생 이름을 입력해주세요. : ");
		String name = scan.next();
		
		//delete
		String sql = " DELETE FROM STUDENT"
				   + " WHERE NAME = ? ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		if(count > 0) {
			System.out.println("삭제되었습니다.");
		} else { System.out.println("삭제되지 않았습니다."); }
		
	}
	
	public void Read() {
		System.out.print("정보를 찾으려는 학생의 이름을 입력해주세요. : ");
		String name = scan.next();
		
		// search
		String sql = " SELECT NUM, NAME, KOR, ENG, MATH "
				   + " FROM STUDENT "
				   + " WHERE NAME = ? ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		StudentDto dto = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				int _number = rs.getInt("num");
				String _name = rs.getString("name");
				int _kor = rs.getInt("kor");
				int _eng = rs.getInt("eng");
				int _math = rs.getInt("math");
				
				dto = new StudentDto(_number, _name, _kor, _eng, _math);
				System.out.println(dto.toString());
				
				System.out.println("출력되었습니다.");
			} else { System.out.println("일치하는 정보가 없습니다."); }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
	}
	
	public void Update() {
		System.out.print("정보를 수정할 학생의 이름을 입력해주세요. : ");
		String name = scan.next();
		
		System.out.print("무엇을 수정하시겠습니까? (KOR/ENG/MATH) : ");
		String subject = scan.next();
		
		System.out.print("수정할 값을 입력해주세요. : ");
		int grade = scan.nextInt();
		
		// update
		String sql = " UPDATE STUDENT "
				   + " SET " + subject + " = ? "
				   + " WHERE NAME = ? ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, grade);
			psmt.setString(2, name);
			
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBClose.close(conn, psmt, null); }
		
		if(count > 0) {
			System.out.println("수정되었습니다.");
		} else { System.out.println("수정되지 않았습니다."); }
		
	}
	
	public void allPrint() {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<StudentDto> list = new ArrayList<>();
		
		// allprint
		String sql = " SELECT NUM, NAME, KOR, ENG, MATH "
				   + " FROM STUDENT ";
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int _number = rs.getInt("num");
				String _name = rs.getString("name");
				int _kor = rs.getInt("kor");
				int _eng = rs.getInt("eng");
				int _math = rs.getInt("math");
				
				StudentDto dto = new StudentDto(_number, _name, _kor, _eng, _math);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { DBClose.close(conn, psmt, rs); }
		
		for(StudentDto dto : list) {
			System.out.println(dto.toString());
		}

	}

}
