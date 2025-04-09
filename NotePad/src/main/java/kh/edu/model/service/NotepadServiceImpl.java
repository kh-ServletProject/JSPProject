package kh.edu.model.service;

import static kh.edu.common.JDBCTemplate.*;

import java.sql.Connection;

import kh.edu.model.dao.NotepadDAOImpl;
import kh.edu.model.dao.NotepadDao;

public class NotepadServiceImpl implements NotepadService {

	private NotepadDao dao = new NotepadDAOImpl();
	
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
