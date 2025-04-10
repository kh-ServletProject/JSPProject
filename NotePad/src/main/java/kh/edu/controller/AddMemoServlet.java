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

@WebServlet("/addMemo")
public class AddMemoServlet extends HttpServlet {

	/** 
	 *    
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
		
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	try {
		HttpSession session = req.getSession();
		
		Member member = (Member)session.getAttribute("member");
		if (member == null) {
			
			resp.sendRedirect("/login");
		    return;
		}
		
		int memberNo = member.getMemberNo();
		
		NotepadService service = new NotepadServiceImpl();
		
		String memoTitle = req.getParameter("memoTitle");
		String memoContent = req.getParameter("memoContent");
		
		int result = service.addMemo(memoTitle,memoContent,memberNo);
		String message = null;
	
		if(result > 0) message = "메모추가성공";
		else           message = "실패";

		
		session.setAttribute("message",message);
		
		resp.sendRedirect("/login");
		
	}catch (Exception e){
		e.printStackTrace();
	}
}
	
	
	
}