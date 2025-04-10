package kh.edu.model.service;

import java.sql.Connection;

import java.util.List;

import static kh.edu.common.JDBCTemplate.*;
import kh.edu.model.dao.NotepadDAOImpl;
import kh.edu.model.dao.NotepadDao;
import kh.edu.model.dto.Member;
import kh.edu.model.dto.Memo;

public class NotepadServiceImpl implements NotepadService {

	NotepadDao dao = new NotepadDAOImpl();
	
	@Override
	public Member loginMember(String memberId, String memberPw) throws Exception {

		Connection conn = getConnection();
		
		Member member = dao.loginMember(conn, memberId, memberPw);
		
		close(conn);
		
		return member;
	}

	@Override
	public List<Memo> memberMemoList(int memberNo) throws Exception {

		Connection conn = getConnection();
		
		List<Memo> memoList = dao.memberMemoList(conn, memberNo);
		
		close(conn);
		
		return memoList;

	}

  	@Override
	public int memoUpdate(int memoNo, String title, String content) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.memoUpdate(conn, memoNo, title, content);
		
		// 트랜잭션 제어 처리
		if(result>0) commit(conn);
		else 		 rollback(conn);
		
		close(conn);		
		
		return result;
  }
  
  @Override
	public Memo memoDetail(int memoNo) throws Exception {
		
		
			Connection conn = getConnection();
			
			NotepadDao dao = new NotepadDAOImpl();
			
			Memo memo = dao.memoDetail(conn, memoNo);
			
			close(conn);
			
			return memo;
			
	}

	@Override
	public int memoDelete(int memoNo) throws Exception {
		
		Connection conn = getConnection();
		
		NotepadDao dao = new NotepadDAOImpl();
		
		int result = dao.memoDelete(conn, memoNo);
		
		if(result > 0) JDBCTemplate.commit(conn);
		else		   JDBCTemplate.rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	/**
	 *회원가입하는 서비스단메서드입니다.
	 */
	@Override
	public int signUp(String memberId, String memberPw, String memberName) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(memberId,memberPw,memberName,conn);
	
		
		
		//트랜잭션 처리
		
		if(result >0) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	
	
}
