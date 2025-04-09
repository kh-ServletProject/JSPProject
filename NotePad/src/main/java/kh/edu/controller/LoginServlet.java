package kh.edu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int memberId = Integer.parseInt(req.getParameter("memberId"));
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인 서블릿 오류입니다.");
		}
		
	}
}
