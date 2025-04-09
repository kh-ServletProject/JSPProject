package kh.edu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kh.edu.model.service.NotepadService;
import kh.edu.model.service.NotepadServiceImpl;

@WebServlet("/memo/add")
public class AddnoteServlet extends HttpServlet {

	/** 메모 페이지에성 add 버튼을 눌럿을떄!
	 *  아마도 흠 .. memberNo , input의 title과, input의  
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			NotepadService service = new NotepadServiceImpl();
			
			String 
			
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
