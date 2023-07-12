package todolist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todolist.member.model.service.TodoService;

@WebServlet("/deleteList")
public class DeleteListServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TodoService service = new TodoService();
			String span = req.getParameter("spanInput");
			
			int result = service.deleteList(span);
			if ( result> 0 ) {
				System.out.println("딜리트성공");
			}else {
				System.out.println("딜리트실패");
			}
			resp.getWriter().print(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}