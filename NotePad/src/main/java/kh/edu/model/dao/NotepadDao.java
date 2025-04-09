package kh.edu.model.dao;

import java.sql.Connection;

public interface NotepadDao {

	int memoUpdate(Connection conn, int memoNo, String title, String content) throws Exception;

}
