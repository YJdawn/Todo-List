package todolist.member.model.dao;

import static todolist.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import todolist.member.model.vo.TodoList;

public class TodoDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public TodoDAO() {
		try {
			prop = new Properties();
			String filePath = TodoDAO.class.getResource("/todolist/sql/Todo-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * TodoList 작성 데이터저장
	 * 
	 * @param conn
	 * @param inputTodo
	 * @return
	 * @throws Exception
	 */
	public int insertTodo(Connection conn, String inputTodo) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("insertTodo");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputTodo);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 전체삭제 DAO
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int allListDelete(Connection conn) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("allListDelete");
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// List 삭제 추가
	public int deleteList(Connection conn, String span) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("deleteList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, span);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 전체목록 뽑아오기
	 * 
	 * @param conn
	 * @return
	 */
	public List<TodoList> selectAll(Connection conn) throws Exception {

		List<TodoList> todoList = new ArrayList<>();
		try {
			String sql = prop.getProperty("selectAll");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int testNo = rs.getInt("TESTNO");
				String testAddTodo = rs.getString("TESTADDTODO");
				String testDate = rs.getString("TESTDATE");

				todoList.add(new TodoList(testNo, testAddTodo, testDate));
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return todoList;
	}
	/**        체크 유무 바꾸기
	 * @param conn
	 * @param checkList
	 * @return
	 */
	public int checkList(Connection conn, String checkList) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("checkList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkList);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int unCheckList(Connection conn, String checkList) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("unCheckList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkList);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/**    선택된거 삭제
	 * @param conn
	 * @return
	 */
	public int checkedDelete(Connection conn) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("checkedDelete");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}finally {
			close(stmt);
		}
		
		return result;
	}
	/**   체크박스 체크
	 * @param conn
	 * @param spanInput
	 * @return
	 * @throws Exception
	 */
	public int checkcheck(Connection conn, String spanInput) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("checkcheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, spanInput);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
