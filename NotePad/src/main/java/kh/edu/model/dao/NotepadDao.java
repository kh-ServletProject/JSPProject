package kh.edu.model.dao;

import java.sql.Connection;

public interface NotepadDao {

	int signUp(String memberId, String memberPw, String memberName, Connection conn)throws Exception;
	//회원가입하는 메서드

}
