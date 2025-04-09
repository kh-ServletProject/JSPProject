package kh.edu.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static kh.edu.common.JDBCTemplate.*;

public class NotepadDAOImpl implements NotepadDao {
	
	private Properties prop;
	private Statement stmt ;
	private PreparedStatement pstmt ;
	private ResultSet rs;
	
public NotepadDAOImpl() {
	
	try {
		String path = NotepadDAOImpl.class.getResource("/xml/sql.xml").getPath();
		
		prop = new Properties();
		prop.loadFromXML(new FileInputStream(path));
		
	}catch (Exception e){
		e.printStackTrace();
	}
}
	
	 
	
	@Override
	public int signUp(String memberId, String memberPw, String memberName, Connection conn) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			pstmt.setString(3, memberName);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		
		return result;
	}

}
