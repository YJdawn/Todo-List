package todolist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todolist.member.model.service.TodoService;

@WebServlet("/AllListDelete")
public class AllListDeleteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TodoService service = new TodoService();		
			int result = service.allListDelete();
			
			if ( result > 0 ) {
				System.out.println("전체삭제 성공");
			}else {
				System.out.println("전체삭제 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}