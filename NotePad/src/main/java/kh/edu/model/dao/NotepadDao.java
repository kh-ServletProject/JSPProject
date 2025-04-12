package kh.edu.model.dao;

import java.sql.Connection;

import java.util.List;
import kh.edu.model.dto.Member;
import kh.edu.model.dto.Memo;

public interface NotepadDao {

	int findId(Connection conn, String memberId) throws Exception;

	int signUp(String memberId, String memberPw, String memberName, Connection conn)throws Exception;

	Member loginMember(Connection conn, String memberId, String memberPw) throws Exception;

	List<Memo> memberMemoList(Connection conn, int memberNo) throws Exception;
  
	int memoUpdate(Connection conn, int memoNo, String title, String content) throws Exception;
  
  	Memo memoDetail(Connection conn, int memoNo) throws Exception;

	int memoDelete(Connection conn, int memoNo) throws Exception;
	
//	List<Memo> memberBinList(Connection conn, int memberNo) throws Exception;

	int memoGoBin(Connection conn, int memoNo) throws Exception;

	int addMemo(int memberNo, String memoTitle, String memoContent, Connection conn) throws Exception;

	int memoRollback(Connection conn, int memoNo) throws Exception;
}
