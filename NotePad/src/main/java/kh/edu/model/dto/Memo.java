package kh.edu.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Memo {
	private int memoNo;
	private String memoTitle;
	private String memoContent;
	private String writeDate;
	private String updateDate;
	private int memberNo;

}
