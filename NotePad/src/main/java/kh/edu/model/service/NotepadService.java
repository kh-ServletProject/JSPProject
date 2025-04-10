package kh.edu.model.service;

import java.util.List;
import kh.edu.model.dto.Member;
import kh.edu.model.dto.Memo;

public interface NotepadService {


	Memo memoDetail(int memoNo) throws Exception;

	int memoDelete(int memoNo) throws Exception;

	/** 로그인 회원 조회
	 * @param memberId 멤버 아이디
	 * @param memberPw 멤버 비밀번호
	 * @return Member(로그인한 회원), null
	 * @throws Exception
	 */
	Member loginMember(String memberId, String memberPw) throws Exception;

	/** 메모 리스트 조회
	 * @param memberId
	 * @return List<>(현재 회원의 메모 리스트), null
	 * @throws Exception
	 */
	List<Memo> memberMemoList(int memberNo) throws Exception;

	int memoUpdate(int memoNo, String title, String content) throws Exception;
	
	/**회원가입 
	 * @param memberId
	 * @param memberPw
	 * @param memberName
	 * @return
	 * @throws Exception
	 */
	int signUp(String memberId, String memberPw, String memberName) throws Exception;

	/**회원가입 하기전에 memberId가 중복되지않는지 조회
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	int findId(String memberId) throws Exception;

	

	int addMemo(String memoTitle, String memoContent, int memberNo)throws Exception;

}
