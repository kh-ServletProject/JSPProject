package kh.edu.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kh.edu.model.dto.Member;
import kh.edu.model.dto.Memo;
import kh.edu.model.service.NotepadService;
import kh.edu.model.service.NotepadServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// index.jsp에서 넘어온 memberId, memberPw 받아줌
			String memberId = req.getParameter("memberId");
			String memberPw = req.getParameter("memberPw");
			
			// 서비스 객체 생성
			NotepadService service = new NotepadServiceImpl();
			
			// 서비스 메서드 호출
			Member loginMem = service.loginMember(memberId, memberPw);
			
			if(loginMem == null) { // 아이디와 비밀번호가 일치하는 회원이 없을 경우
				
				// 다시 초기 화면으로 forward
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}
			
			// 일치하는 회원이 있다면 session에 Member 객체 저장
			req.getSession().setAttribute("member", loginMem);
			
			// 로그인한 회원의 메모 리스트를 가져오는 서비스 메서드 호출
			List<Memo> memoList = service.memberMemoList(loginMem.getMemberNo());
			
			// request에 가져온 메모 리스트 저장
			req.setAttribute("memoList", memoList);
			
			req.getRequestDispatcher("/WEB-INF/views/fullView.jsp").forward(req, resp);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인 서블릿 오류입니다.");
		}
		
	}
}
