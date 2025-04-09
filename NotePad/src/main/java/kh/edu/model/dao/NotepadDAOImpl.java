package kh.edu.model.dao;

import static kh.edu.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import kh.edu.model.dto.Member;
import kh.edu.model.dto.Memo;

public class NotepadDAOImpl implements NotepadDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Properties prop = null;
	
	public NotepadDAOImpl() {

		// sql.xml을 가져올 수 있도록 prop 세팅
		String path = NotepadDAOImpl.class.getResource("/xml/sql.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(path));
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("sql.xml 불러오기 실패");
		}
	}
	
	@Override
	public Member loginMember(Connection conn, int memberId, String memberPw) throws Exception {

		Member member = null;
		
		try {
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return null;
	}

	@Override
	public List<Memo> memberMemoList(Connection conn, int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
