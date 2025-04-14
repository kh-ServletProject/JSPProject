package kh.edu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
	private int memoNo;			// 메모 번호
	private String memoTitle;	// 메모 제목
	private String memoContent;	// 메모 내용
	private String writeDate;	// 작성(생성) 날짜
	private String updateDate;	// 수정 날짜
	private int memberNo;		// 메모를 소유한 회원 번호
	private char deleted;		// 삭제 여부(휴지통)
}
