package kh.edu.model.service;

import java.sql.Connection;

import kh.edu.common.JDBCTemplate;
import kh.edu.model.dao.NotepadDAOImpl;
import kh.edu.model.dao.NotepadDao;
import kh.edu.model.dto.Memo;

public class NotepadServiceImpl implements NotepadService {

	@Override
	public Memo memoDetail(int memoNo) throws Exception {
		
		
			Connection conn = JDBCTemplate.getConnection();
			
			NotepadDao dao = new NotepadDAOImpl();
			
			Memo memo = dao.memoDetail(conn, memoNo);
			
			JDBCTemplate.close(conn);
			
			return memo;
			
	}

	@Override
	public int memoDelete(int memoNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		NotepadDao dao = new NotepadDAOImpl();
		
		int result = dao.memoDelete(conn, memoNo);
		
		if(result > 0) JDBCTemplate.commit(conn);
		else		   JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
