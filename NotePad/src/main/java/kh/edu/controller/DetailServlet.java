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

@WebServlet("/memo/detail")
public class DetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
		NotepadService service = new NotepadServiceImpl();
		
		int memoNo = Integer.parseInt(req.getParameter("memoNo"));
		
		Memo memo = service.memoDetail(memoNo);
		
		if(memo==null) { // 애초에 메모가 없으면 제목을 클릭할 수 없으니까 이 코드는 필요가 없지 않을까 싶긴 합니다
			HttpSession session = req.getSession();
			session.setAttribute("message", "매모가 존재하지 않습니다.");
			
			resp.sendRedirect("/");
			return;
			
		}
		
		req.setAttribute("memo", memo);
		
		String path = "/WEB-INF/views/detail.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
