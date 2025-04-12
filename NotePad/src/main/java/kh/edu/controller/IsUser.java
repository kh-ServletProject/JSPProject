package kh.edu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.edu.model.dto.Member;

@WebServlet("/isUser")
public class IsUser extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String memberPw = req.getParameter("memberPw");
			
			HttpSession session = req.getSession();
			Member loginMem = (Member) session.getAttribute("member"); // 세션에서 로그인 객체 꺼내기
			
			if(memberPw.equals(loginMem.getMemberPw())) {
				req.getSession().setAttribute("pwCheck", true); // jsp 에서 display 의 변경을 위한 장치
				resp.sendRedirect("/updateUserInfo");
			} else {
				req.getSession().setAttribute("message","비밀번호가 일치하지 않습니다.");
				resp.sendRedirect("/updateUserInfo");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
