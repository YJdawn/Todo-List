package todolist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todolist.member.model.service.TodoService;

@WebServlet("/checkedDelete")
public class CheckedDeleteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TodoService service = new TodoService();	
			
			int result = service.checkedDelete();
			if ( result > 0 ) {
				System.out.println("check 삭제");
			}else {
				System.out.println("check 삭제실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
