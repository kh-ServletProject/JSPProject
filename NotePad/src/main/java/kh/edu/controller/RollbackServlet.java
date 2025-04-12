package kh.edu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.edu.model.service.NotepadService;
import kh.edu.model.service.NotepadServiceImpl;

@WebServlet("/memo/rollback")
public class RollbackServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			NotepadService service = new NotepadServiceImpl();

			String[] memoNumbers = req.getParameterValues("memoNo");

			int result = 0;
			int count = 0;

			if (memoNumbers != null) {
				for (String memoNo : memoNumbers) {
					System.out.println("복구할 메모번호: " + memoNo);
					result = service.memoRollback(Integer.parseInt(memoNo));
					count++;
				}
			}

			// session scope 객체 얻어오기
			HttpSession session = req.getSession();
			if (result > 0 && count == memoNumbers.length) {
				session.setAttribute("message", count + "개를 복구하였습니다!");
				resp.sendRedirect("/login");

				return;
			}

			session.setAttribute("message", "복구 실패하였습니다.");
			resp.sendRedirect("/login");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
