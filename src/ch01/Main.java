package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis";
		
		Connection conn = null; //연결해주는?
		PreparedStatement stmt = null;
		ResultSet rs = null; //response 를 저장할 객체
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클의 코드를 vm으로 넘긴다.
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 연결
			
			String query = "select user_id, user_name, reg_date from users"; // 스테이트먼트로 넘긴다
			stmt = conn.prepareStatement(query); //스테이트먼트를 커넥션을통해 오라클로 보낸다.
			rs = stmt.executeQuery(); // or맵핑
			
			User user = null; 
			while(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getDate(3)); // 유저 아이디, 네임, 데이터
				System.out.println(user);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close(); // 역순으로 제거한다.
			}catch(Exception e) {}
		}
	}
}
