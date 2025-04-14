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

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String memberId = req.getParameter("memberId");
			String memberPw = req.getParameter("memberPw");
			String memberName = req.getParameter("memberName");
			
			NotepadService service = new NotepadServiceImpl();
			HttpSession session = req.getSession();
			Member loginMem = (Member) session.getAttribute("member");
			
			int result = service.updateUser(memberId, memberPw, memberName, loginMem.getMemberNo());
			
			if(result > 0) {
				session.setAttribute("message","회원 정보 수정 성공! 다시 로그인 해 주세요.");
				resp.sendRedirect("/");
				
				return;
			} else {
				
				session.setAttribute("message","회원 정보 수정 실패..");
				resp.sendRedirect("/login");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}
	
}
