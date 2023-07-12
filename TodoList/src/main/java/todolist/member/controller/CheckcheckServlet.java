package todolist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todolist.member.model.service.TodoService;

@WebServlet("/checkcheck")
public class CheckcheckServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			TodoService service = new TodoService();
			String spanInput = req.getParameter("spanInput1");
			
			int result = service.checkcheck(spanInput);
			System.out.println(result);
			
			resp.getWriter().print(result);
		}catch(Exception e) {
			
		}
	}
}