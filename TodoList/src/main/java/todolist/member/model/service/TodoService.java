package todolist.member.model.service;

import static todolist.common.JDBCTemplate.close;
import static todolist.common.JDBCTemplate.commit;
import static todolist.common.JDBCTemplate.getConnection;
import static todolist.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import todolist.member.model.dao.TodoDAO;
import todolist.member.model.vo.TodoList;

public class TodoService {
	private TodoDAO dao = new TodoDAO();

	/**
	 * Todo db 추가 서비스
	 * 
	 * @param inputTodo
	 * @return
	 * @throws Exception
	 */
	public int insertTodo(String inputTodo) throws Exception {

		Connection conn = getConnection();
		int result = dao.insertTodo(conn, inputTodo);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}

	/**
	 * 전체삭제 서비스
	 * 
	 * @return
	 * @throws Exception
	 */
	public int allListDelete() throws Exception {

		Connection conn = getConnection();
		int result = dao.allListDelete(conn);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}

	/**
	 * 한개삭제 서비스 .
	 * 
	 * @param span
	 * @return
	 */
	public int deleteList(String span) throws Exception {

		Connection conn = getConnection();
		int result = dao.deleteList(conn, span);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}

	/**
	 * 전체목록 뽑아오기
	 * 
	 * @return
	 */
	public List<TodoList> selectAll() throws Exception {
		Connection conn = getConnection();

		List<TodoList> todoList = dao.selectAll(conn);

		close(conn);

		return todoList;
	}

	/**
	 * 체크 유무
	 * 
	 * @param checkList
	 * @return
	 */
	public int checked(String checkList) throws Exception {
		Connection conn = getConnection();
		int result = dao.checkList(conn, checkList);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	public int unChecked(String checkList) throws Exception {
		Connection conn = getConnection();
		int result = dao.unCheckList(conn, checkList);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	/**
	 * 체크된거 삭제
	 * 
	 * @return
	 */
	public int checkedDelete() throws Exception {
		Connection conn = getConnection();
		int result = dao.checkedDelete(conn);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return 0;
	}
	/**      체크박스 체크 확인
	 * @param spanInput
	 * @return
	 * @throws Exception
	 */
	public int checkcheck(String spanInput) throws Exception {
		Connection conn = getConnection();
		int result = dao.checkcheck(conn,spanInput);
		
		close(conn);

		return result;
	}
}