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
	private int memoNo;
	private String memoTitle;
	private String memoContent;
	private String writeDate;
	private String updateDate;
	private int memberNo;
	private char deleted;
}
