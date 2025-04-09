package kh.edu.model.service;

import kh.edu.model.dto.Memo;

public interface NotepadService {

	Memo memoDetail(int memoNo) throws Exception;

	int memoDelete(int memoNo) throws Exception;

}
