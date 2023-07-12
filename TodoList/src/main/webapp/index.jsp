<%@ page language="java" contentType="text/html; cherset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="resources/css/todocss.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

</head>
<html>
<body>
	<div class="container">
		<h1>To_Do List</h1>
		<section class="form1">
			<input type="text" placeholder="Add New To-Do" id="inputTodo">
			<button type="summit" id="addBtn">Add</button>
		</section>

		<ul class="todo-list" id="todo-listId">
		
		</ul>

		<div id="footer">
			<span id="countSpan"> 남은 Todo : </span> <span
				id="countSpanInput"></span> <span id="All">ALL</span> <span
				id="Active">Active</span> <span id="Complete">Complete</span>
			<button type="button" id="checkDelete">Check Delete</button>
			&nbsp;
			<button type="button" id="allDelete">All Delete</button>
		</div>
	</div>

	<script src="resources/js/todojs.js"></script>
</body>
</html>