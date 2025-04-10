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

@WebServlet("/memo/bin")
public class BinServlet extends HttpServlet{ // 휴지통 화면 보여부기
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {
				// 서비스 객체 생성
				NotepadService service = new NotepadServiceImpl();

				Member loginMem = (Member) req.getSession().getAttribute("member");
				
				List<Memo> memoList = service.memberMemoList(loginMem.getMemberNo());

				
				req.setAttribute("memoList", memoList);

				req.getRequestDispatcher("/WEB-INF/views/bin.jsp").forward(req, resp);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
