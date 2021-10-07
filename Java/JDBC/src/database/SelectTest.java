package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.UserDto;

public class SelectTest {
	// insert, update와 달리 DB 내용에 영향을 주지 않음. 그저 가져올뿐
	
	// 하나의 데이터만을 취득
	public UserDto search(String id) {	// UserDto 객체 하나의 정보만 넘어감
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				   + " FROM USERDTO "
				   + " WHERE ID = '" + id + "' ";
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;	// 지금까지 데이터가 입력,수정되었는지 count로만 확인했는데 select는 직접 데이터를 받아와야함
		
		UserDto dto = null;
		
		// 생성
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);	// 결과값을 받음 (select만 executeUpdate가 아님)
			
			if(rs.next() == true) {	// 넘어온 데이터가 있는 경우. true는 생략 가능
				String _id = rs.getString("id");	// 변수아니고 컬럼명
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindte = rs.getString("joindate");
				
				dto = new UserDto(_id, _name, _age, _joindte);	// 데이터 하나를 가져옴
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}
		
		return dto;
	}
	
	public UserDto search2(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				   + " FROM USERDTO "
				   + " WHERE ID = ? ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		UserDto dto = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next() == true) {	// 넘어온 데이터가 있는 경우. true는 생략 가능
				String _id = rs.getString("id");	// 변수아니고 컬럼명
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindte = rs.getString("joindate");
				
				dto = new UserDto(_id, _name, _age, _joindte);	// 데이터 하나를 가져옴
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return dto;
	}
	
	// 다수의 데이터를 취득
	public List<UserDto> getUsers() {	// 여러개의 정보를 가져올땐 리스트
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				   + " FROM USERDTO ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<UserDto> list = new ArrayList<UserDto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	// 계단형으로 전달
			
			while(rs.next()) {	// 자료 여러개 가져오는거니까 while로
				String _id = rs.getString("id");
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");
				
				UserDto dto = new UserDto(_id, _name, _age, _joindate);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;
	}

}
