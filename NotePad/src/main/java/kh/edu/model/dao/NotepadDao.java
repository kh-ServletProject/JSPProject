package kh.edu.model.dao;

import java.sql.Connection;
import java.util.List;

import kh.edu.model.dto.Member;
import kh.edu.model.dto.Memo;

public interface NotepadDao {

	Member loginMember(Connection conn, String memberId, String memberPw) throws Exception;

	List<Memo> memberMemoList(Connection conn, int memberNo) throws Exception;

}
