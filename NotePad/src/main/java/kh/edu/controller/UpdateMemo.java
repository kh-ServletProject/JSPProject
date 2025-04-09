package kh.edu.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kh.edu.common.JDBCTemplate;
import kh.edu.model.dto.Memo;
import kh.edu.model.service.NotepadService;
import kh.edu.model.service.NotepadServiceImpl;

/** 
 * 메모 수정 페이지 - 미애
 */
@WebServlet("/memo/update")
public class UpdateMemo extends HttpServlet {
	
	// 수정 버튼 눌렀을 때 화면에 기존에 가지고 있는 값 뿌려서 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 현재 세션에 저장되어 있는 memoNo
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			//int memberNo = member.getMemberNo();
			
			NotepadService service = new NotepadServiceImpl();
			
			// 조회한 내용 가져오기
			//Memo memo = service.memoDetail(memoNo);
			
			// 임시 데이터 
			Memo memo = Memo.builder()
						.memoNo(1)
						.memoTitle("제목1")
						.memoContent("내용1")
						.writeDate("2025-04-09")
						.updateDate("2025-04-09")
						.memberNo(1).build();

			if(memo == null) {
				// 메인 페이지 redirect
				resp.sendRedirect("/");
				return;
			}
			
			// request scope 에 memo 객체 세팅
			req.setAttribute("memo", memo);
			
			// 요청 발송자를 통해 forward
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 전달받은 파라미터 얻어오기(제목, 상세내용, todoNo)
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));
			
			NotepadService service = new NotepadServiceImpl();
			int result = service.memoUpdate(memoNo, title, content);
			
			// 수정 성공 시
			// 상세 조회 페이지로 redirect
			// "수정되었습니다" message를 alert출력
			
			// 수정 실패 시
			// 수정 화면으로 redirect
			// "수정 실패" messagae를 alert 출력
			String url = null;
			String message = null;
			
			if(result > 0) { // 성공
				url = "/memo/detail?memoNo=" + memoNo;
				message = "수정되었습니다!";
			} else { //실패
				
				url = "/memo/update?memoNo=" + memoNo;
				message = "수정 실패ㅠ";
				
			}
			
			// session 객체에 속성 추가
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(url);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
