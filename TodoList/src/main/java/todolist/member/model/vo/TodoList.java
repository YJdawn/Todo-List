package todolist.member.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoList {
	private int testNo;
	private String testAddTodo;
	private String testDate;
	
	public TodoList() {
	}
	
	public TodoList(int testNo, String testAddTodo, String testDate) {
		this.testNo = testNo;
		this.testAddTodo = testAddTodo;
		this.testDate = testDate;
	}

}
