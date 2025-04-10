package kh.edu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.edu.model.dto.Memo;
import kh.edu.model.service.NotepadService;
import kh.edu.model.service.NotepadServiceImpl;

@WebServlet("/memo/delete")
public class DeleteServlet extends HttpServlet { // 휴지통에서 완전히 삭제하기

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] memoNos = req.getParameterValues("memoNo");

		HttpSession session = req.getSession();
		NotepadService service = new NotepadServiceImpl();

		int successCount = 0;

		if (memoNos != null) {
			for (String memoNoStr : memoNos) {
				try {
					int memoNo = Integer.parseInt(memoNoStr);
					int result = service.memoDelete(memoNo);

					if (result > 0) {
						successCount++;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// 삭제 결과 메시지 세션에 저장
		String message = (successCount > 0) ? successCount + "개의 메모가 삭제되었습니다." : "삭제할 메모를 선택해주세요.";

		session.setAttribute("message", message);

		// 반복문 밖에서 리디렉션
		resp.sendRedirect(req.getContextPath() + "/login"); // 적절한 목록 페이지로 이동
	}
}