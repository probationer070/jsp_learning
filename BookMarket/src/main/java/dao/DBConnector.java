package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DB 강력하게 생성

public class DBConnector {
	
	// 데이터베이스 연결 주소 선언
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "ecom6";
	private static final String PASSWORD = "1234";
	
	// 데이터 베이스 컨텍터 singleton 으로 생성
	private static DBConnector instance = new DBConnector();
	// 생성자에서  class forName 으로 드라이브 로드
	private DBConnector() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 생성자 singleton 으로 관리
	public static DBConnector getInstance() {
		if(instance == null) {
			synchronized (DBConnector.class) {
				instance = new DBConnector();				
			}
		}
		return instance;
	}
	
	// Connection 객체 전달자 1개
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
