package kh.edu.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/*
 * JEBC 관련 중요 작업들을 처리해주는 Template
 */
public class JDBCTemplate {

	// Service 클래스 내에서 사용하게 될 conn 객체
	private static Connection conn = null;

	/**
	 * 호출 시 Connection 객체를 생성해서 반환하는 메서드 + AutoCommit 끄기
	 * 
	 * @return conn
	 */
	public static Connection getConnection() {

		try {
			// 기존 conn이 있고, 닫혀 있지 않다면 기존 conn 반환
			if (conn != null && !conn.isClosed()) {
				return conn;
			}

			// Properties 객체 생성
			Properties prop = new Properties();

			// Properties 가 제공하는 메서드를 이용해서 driver.xml 파일 내용을 읽어오기
			// src/main/resources 경로상에 위치한 driver.xml 파일 읽어오기
			String filePath = JDBCTemplate.class.getResource("/xml/driver.xml").getPath();
			// 지정된 리소스 파일의 절대 경로를 찾는 메서드

			System.out.println(filePath);

			// fileInputStream 객체를 생성
			// 해당 경로로 loadFromXML 실행해서 내용 가져옴
			prop.loadFromXML(new FileInputStream(filePath));

			// prop 에 저장된 값을 이용해서 Connection 객체 생성
			Class.forName(prop.getProperty("driver"));

			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("userName"), prop.getProperty("password"));
			// conn = DriverManager.getConnection

			// 만들어진 Connection에서 AutoCommit 끄기
			conn.setAutoCommit(false);

		} catch (Exception e) {
			System.out.println("커넥션 생성중 예외 발생");
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 전달받은 커넥션에서 수행한 SQL을 COMMIT 하는 메서드
	 * 
	 * @param conn
	 */
	public static void commit(Connection conn) {

		try {
			if (conn != null && !conn.isClosed())
				conn.commit();

		} catch (Exception e) {
			System.out.println("커밋중 예외 발생");
			e.printStackTrace();
		}
	}

	/**
	 * 전달받은 커넥션에서 수행한 SQL을 ROLLBACK 하는 메서드
	 * 
	 * @param conn
	 */
	public static void rollback(Connection conn) {

		try {
			if (conn != null && !conn.isClosed())
				conn.rollback();

		} catch (Exception e) {
			System.out.println("롤백중 예외발생");
			e.printStackTrace();
		}
	}

	/**
	 * 전달받은 Connection을 close 하는 메서드
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {

		try {
			if (conn != null && !conn.isClosed())
				conn.close();

		} catch (Exception e) {
			System.out.println("커넥션 close 중 예외발생");
			e.printStackTrace();
		}
	}

	/**
	 * 전달받은 Statment or PreparedStatement 둘다 close 해주는 메서드
	 * 
	 * @param stmt
	 */
	public static void close(Statement stmt) {

		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();

		} catch (Exception e) {
			System.out.println("Statment close 중 예외발생");
			e.printStackTrace();
		}
	}

	/**
	 * 전달받은 ResultSet을 close 하는 메서드
	 * 
	 * @param rs
	 */
	public static void close(ResultSet rs) {

		try {
			if (rs != null && !rs.isClosed())
				rs.close();

		} catch (Exception e) {
			System.out.println("rs close중 예외발생");
			e.printStackTrace();
		}
	}
}
