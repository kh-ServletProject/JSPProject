package kh.edu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.edu.model.dto.Member;
import kh.edu.model.service.NotepadService;
import kh.edu.model.service.NotepadServiceImpl;

@WebServlet("/signup")
public class SignUpProcessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/signupProcess.jsp").forward(req, resp);
	}

	/**
	 * 회원가입페이지에서 받아온 값들을 읽어오는 Servlet 입니다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			NotepadService service = new NotepadServiceImpl();
			String message = null;

			String memberId = req.getParameter("memberId");
			String memberPw = req.getParameter("memberPw");
			String memberName = req.getParameter("memberName");
			// 파라미터값들 가져오기

			// required 를 줫긴햇는데 조건문을 쓸까 ? .. 회의해보기

			// INSERT 가성공되면 1행 성공 or 실패 메시지 Session 스코프에 담아보기

			int count = service.findId(memberId);

			if (count == 1) {

				message = "중복되는 ID가 있습니다. 다시시도해주세요";

				// req.setAttribute("message", message);

				req.getSession().setAttribute("message", message);

				resp.sendRedirect("/signup");
				// req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}

			int result = service.signUp(memberId, memberPw, memberName);

			if (result > 0) {
				message = "회원가입에 성공하였습니다! 홈페이지에서 로그인후 이용바랍니다.";
			} else {
				message = "회원가입에 실패하였습니다 ㅠ^ ㅠ 다시시도해주세요.";
			}

			req.getSession().setAttribute("message", message);

			resp.sendRedirect("/");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
