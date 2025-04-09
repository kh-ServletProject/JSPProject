package kh.edu.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static kh.edu.common.JDBCTemplate.*;

public class NotepadDAOImpl implements NotepadDao {

	// JDBC 객체 참조변수 선언 + properties 참조 변수 선언
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		private Properties prop;
		
		// TodoListDAOImpl 생성자 /xml/sql.xml 경로 읽어오기
		public NotepadDAOImpl() {
			//TodoListDAOImpl 객체가 생성될 때 (Service 단에서 new 연산자를 통해 객체화 될때)
			// sql.xml 파일의 내용을 읽어와 Properties prop 객체에 K:V 세팅
			try {
				String filePath = NotepadDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
				prop = new Properties();
				prop.loadFromXML(new FileInputStream(filePath));

			} catch (Exception e) {
				System.out.println("sql.xml 파일 로드 중 예외 발생");
				e.printStackTrace();
			}
			
		}
		
	@Override
	public int memoUpdate(Connection conn, int memoNo, String title, String content) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("memoUpdate");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, memoNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
