package todolist.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTemplate {

	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "workbook", "1234");
			conn.setAutoCommit(false); // 자동커밋 비활성화
		} catch (Exception e) {
			System.out.println("[Connection 생성중 예외 발생]");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Connection 객체 자원 반환메서드
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Statement 객체 자원 반환메서드 ( PreparedStatement(자식) 다형성/ 동적바인딩
	 * 
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ResultSet 객체 자원 반환메서드
	 * 
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed())
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 트랜잭션 Commit 메서드
	 * 
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 트랜잭션 Rollback 메서드
	 * 
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
