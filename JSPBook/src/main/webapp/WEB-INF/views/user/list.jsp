<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>User List</h2>
	<a href="${pageContext.request.contextPath}/users/new">➕ Add User</a>

	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Nickname</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.username}</td>
				<td>${user.nickname}</td>
				<td><a
					href="${pageContext.request.contextPath}/users/edit?id=${user.userId}">Edit</a>
					| <a
					href="${pageContext.request.contextPath}/users/delete?id=${user.userId}"
					onclick="return confirm('삭제할까요?')">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>