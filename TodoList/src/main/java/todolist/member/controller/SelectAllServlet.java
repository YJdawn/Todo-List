package todolist.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import todolist.member.model.service.TodoService;
import todolist.member.model.vo.TodoList;

@WebServlet("/TodoSelectAll")
public class SelectAllServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			TodoService service = new TodoService();
			
			List<TodoList> todoList = service.selectAll();
			
			new Gson().toJson( todoList , resp.getWriter());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
