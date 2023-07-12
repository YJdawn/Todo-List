package todolist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todolist.member.model.service.TodoService;

@WebServlet("/addList")
public class AddListServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TodoService service = new TodoService();
		try {
			String inputTodo = req.getParameter("inputTodo");
			int result = service.insertTodo(inputTodo);
			System.out.println("Servlet "+result);
			if ( result > 0 ) {
				System.out.println("인서트성공");
			}else {
				System.out.println("인서트실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}