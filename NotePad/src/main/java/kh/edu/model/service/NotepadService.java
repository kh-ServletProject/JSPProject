package kh.edu.model.service;

import java.util.List;

import kh.edu.model.dto.Member;
import kh.edu.model.dto.Memo;

public interface NotepadService {

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

}
