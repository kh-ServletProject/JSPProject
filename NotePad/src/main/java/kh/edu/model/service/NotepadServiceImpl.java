package kh.edu.model.service;

import static kh.edu.common.JDBCTemplate.close;
import static kh.edu.common.JDBCTemplate.commit;
import static kh.edu.common.JDBCTemplate.getConnection;
import static kh.edu.common.JDBCTemplate.rollback;

import java.sql.Connection;

import kh.edu.model.dao.NotepadDAOImpl;
import kh.edu.model.dao.NotepadDao;

public class NotepadServiceImpl implements NotepadService {

	private NotepadDao dao = new NotepadDAOImpl();
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

}
