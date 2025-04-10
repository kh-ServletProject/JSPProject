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

}
