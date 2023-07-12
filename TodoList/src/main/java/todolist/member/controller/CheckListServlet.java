package todolist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todolist.member.model.service.TodoService;

@WebServlet("/checkList")
public class CheckListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TodoService service = new TodoService();
			String checkList = req.getParameter("checkList");
			
			int result = service.checked(checkList);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
