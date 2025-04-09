package kh.edu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.edu.model.dto.Member;

@WebServlet("/login") // session Member
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberNo = req.getParameter("memberNo");
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String memberName = req.getParameter("memberName");

        Member member = new Member(memberNo, memberId, memberPw, memberName);

        // 세션에 객체 저장
        HttpSession session = req.getSession();
        session.setAttribute("Member", member);

        // 리다이렉트 또는 다음 페이지 이동
        resp.sendRedirect("detail.jsp"); // detail jsp로 보내기
		
	}

}
