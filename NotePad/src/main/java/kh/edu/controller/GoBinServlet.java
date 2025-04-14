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

@WebServlet("/memo/gobin")
public class GoBinServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 전달받은 파라미터 얻어오기
			int memoNo = Integer.parseInt(req.getParameter("memoNo"));

			NotepadService service = new NotepadServiceImpl();

			int result = service.memoGoBin(memoNo);
			System.out.println("result : " + result);
			// session scope 객체 얻어오기
			HttpSession session = req.getSession();

			if (result > 0) {
				session.setAttribute("message", "휴지통으로 이동하였습니다!");
				resp.sendRedirect("/login");

				return;
			}

			session.setAttribute("message", "휴지통으로 이동을 실패하였습니다.");
			resp.sendRedirect("/login");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
