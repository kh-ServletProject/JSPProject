package kh.edu.model.dao;

import static kh.edu.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kh.edu.model.dto.Member;
import kh.edu.model.dto.Member.MemberBuilder;
import kh.edu.model.dto.Memo;

public class NotepadDAOImpl implements NotepadDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Properties prop = new Properties();
	
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
	public Member loginMember(Connection conn, String memberId, String memberPw) throws Exception {

		Member member = null;
		
		try {
			String query = prop.getProperty("loginMember");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = Member.builder()
						.memberNo(rs.getInt("MEMBER_NO"))
						.memberId(memberId)
						.memberPw(memberPw)
						.memberName(rs.getString("MEMBER_NAME"))
						.build();
			}
						
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

	@Override
	public List<Memo> memberMemoList(Connection conn, int memberNo) throws Exception {

		List<Memo> memoList = new ArrayList<>();
		
		try {
			String query = prop.getProperty("memberMemoList");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memoList.add(Memo.builder()
							.memoNo(rs.getInt(1))
							.memoTitle(rs.getString(2))
							.memoContent(rs.getString(3))
							.writeDate(rs.getString(4))
							.updateDate(rs.getString(5))
							.memberNo(memberNo)
							.deleted(rs.getString(7).charAt(0))
							.build());
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return memoList;

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
			close(rs);
			close(pstmt);
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
			close(pstmt);
		}
		
		return result;
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

	@Override
	public List<Memo> memberBinList(Connection conn, int memberNo) throws Exception {
		
		List<Memo> memoList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("memoBin");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(!rs.next()) {
				memoList.add(Memo.builder()
						.memoNo(rs.getInt(1))
						.memoTitle(rs.getString(2))
						.memoContent(rs.getString(3))
						.writeDate(rs.getString(4))
						.updateDate(rs.getString(5))
						.memberNo(memberNo)
						.build());
			}
			
			
		} finally {
      			close(rs);
			close(pstmt);
		}
  
  return memeoList;
}

	public int findId(Connection conn, String memberId) throws Exception {
		
		int result= 0;
		
		try {
			
			String sql = prop.getProperty("findId");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
		
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				result = rs.getInt(1);
			}

			System.out.println("daoImpl : " + result);
			
		}finally {
			close(rs);
			close(pstmt);
		}
    		return result;
  }
		

	@Override
	public int memoGoBin(Connection conn, int memoNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("goBin");
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memoNo);
				
				result = pstmt.executeUpdate();
				System.out.println("result = " + result);
			
		} finally {
      close(pstmt);
    }

		return result;
	}

	@Override
	public int addMemo(int memberNo,String memoTitle, String memoContent, Connection conn) throws Exception {
		
		int result  = 0;
		
		try {
			String sql = prop.getProperty("addMemo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memoTitle);
			pstmt.setString(2, memoContent);
			pstmt.setInt(3, memberNo);
			
			
			result = pstmt.executeUpdate();
			
		}finally{
			
			close(pstmt);
		}
		
		return result;
	}
}
