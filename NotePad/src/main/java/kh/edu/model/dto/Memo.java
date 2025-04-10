package kh.edu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
=======
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> origin/development
public class Memo {
	private int memoNo;
	private String memoTitle;
	private String memoContent;
	private String writeDate;
	private String updateDate;
	private int memberNo;
}
