package kh.edu.model.dao;

import java.sql.Connection;

import kh.edu.model.dto.Memo;

public interface NotepadDao {

	Memo memoDetail(Connection conn, int memoNo) throws Exception;

	int memoDelete(Connection conn, int memoNo) throws Exception;

}
