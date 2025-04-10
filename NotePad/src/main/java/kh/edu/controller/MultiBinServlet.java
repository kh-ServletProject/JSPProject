package kh.edu.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.edu.model.service.NotepadService;
import kh.edu.model.service.NotepadServiceImpl;

@WebServlet("/memo/multiBin")
public class MultiBinServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	   
		try {
			NotepadService service = new NotepadServiceImpl();
			   
			String[] memoNumbers = req.getParameterValues("memoNo");
			int result = 0;
			int count = 0;
			
			// session scope 객체 얻어오기
			HttpSession session = req.getSession();
			
		   if (memoNumbers == null) {
			   session.setAttribute("message", "한개 이상의 메모를 선택해주세요");
				resp.sendRedirect("/login");
				return;
		   }
		   
		for (String memoNo : memoNumbers) {
		        System.out.println("삭제할 메모번호: " + memoNo);
		    result = service.memoGoBin(Integer.parseInt(memoNo));
		    count ++;
		}
			
		if(result > 0 && count == memoNumbers.length) {
			session.setAttribute("message", count + "개를 휴지통으로 이동하였습니다!");
			resp.sendRedirect("/login");
			
			return;
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
