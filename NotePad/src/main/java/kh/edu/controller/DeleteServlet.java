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
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
		int memoNo = Integer.parseInt(req.getParameter("memoNo"));
		
		NotepadService service = new NotepadServiceImpl();
		
		int result = service.memoDelete(memoNo);
		
		HttpSession session = req.getSession();
		
		String message = null;
		if(result > 0) message = "메모가 삭제되었습니다";
		else		   message = "메모가 존재하지 않습니다.";
		
		session.setAttribute("message", message);
		
		resp.sendRedirect("/");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
