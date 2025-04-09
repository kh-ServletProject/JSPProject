package kh.edu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import kh.edu.common.JDBCTemplate;
import kh.edu.model.dto.Memo;

public class NotepadDAOImpl implements NotepadDao{
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;

	@Override
	public Memo memoDetail(Connection conn, int memoNo) throws Exception {
		
		Memo memo = null;
		
		try {
			
			String sql = prop.getProperty("memoDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memoNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				memo = Memo.builder().
						memoNo(memoNo).
						memoTitle(rs.getString("MEMO_TITLE")).
						memoContent(rs.getString("MEMO_CONTENT")).
						writeDate(rs.getString("WRITE_DATE")).
						updateDate(rs.getString("UPDATE_DATE")).build();
						
			}
			
			
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return memo;
		
	}

	@Override
	public int memoDelete(Connection conn, int memoNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("memoDelete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memoNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
