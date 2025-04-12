package kh.edu.model.service;

import java.util.List;
import kh.edu.model.dto.Member;
import kh.edu.model.dto.Memo;

public interface NotepadService {

	/** 회원가입 이전 memberId 중복여부 조회
	 * @param memberId
	 * @return 중복은 1, 중복이 아니면 0
	 * @throws Exception
	 */
	int findId(String memberId) throws Exception;
	
	/** 회원가입 
	 * @param memberId
	 * @param memberPw
	 * @param memberName
	 * @return
	 * @throws Exception
	 */
	int signUp(String memberId, String memberPw, String memberName) throws Exception;

	/** 로그인 회원 조회
	 * @param memberId 멤버 아이디
	 * @param memberPw 멤버 비밀번호
	 * @return Member(로그인한 회원), null
	 * @throws Exception
	 */
	Member loginMember(String memberId, String memberPw) throws Exception;
	
	/** 메모 리스트 조회
	 * @param memberId
	 * @return memoList(현재 회원의 메모 리스트), null
	 * @throws Exception
	 */
	List<Memo> memberMemoList(int memberNo) throws Exception;

	/** 메모 수정
	 * @param memoNo
	 * @param title
	 * @param content
	 * @return
	 * @throws Exception
	 */
	int memoUpdate(int memoNo, String title, String content) throws Exception;

	/** 디테일 목록 조회
	 * @param memoNo
	 * @return
	 * @throws Exception
	 */
	Memo memoDetail(int memoNo) throws Exception;

	/** 메모 삭제
	 * @param memoNo
	 * @return
	 * @throws Exception
	 */
	int memoDelete(int memoNo) throws Exception;
	
//	List<Memo> memberBinList(int memberNo) throws Exception;

	/** 메모 휴지통으로 이동
	 * @param memoNo
	 * @return
	 * @throws Exception
	 */
	int memoGoBin(int memoNo) throws Exception;

	/** 메모 추가
	 * @param memoTitle
	 * @param memoContent
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	int addMemo(String memoTitle, String memoContent, int memberNo)throws Exception;

	/** 메모 복구
	 * @param memoNo
	 * @return result(복구 결과)
	 * @throws Exception
	 */
	int memoRollback(int memoNo) throws Exception;


}
