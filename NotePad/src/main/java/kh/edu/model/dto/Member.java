package kh.edu.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;

}
