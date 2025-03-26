<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<h2>User List</h2>
<a href="${pageContext.request.contextPath}/users/new"
	class="btn btn-primary mb-3">➕ Add User</a>

<table class="table table-bordered">
	<thead class="table-light">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Nickname</th>
			<th>Actions</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.username}</td>
				<td>${user.nickname}</td>
				<td><a
					href="${pageContext.request.contextPath}/users/edit?id=${user.userId}"
					class="btn btn-sm btn-warning">Edit</a> <a
					href="${pageContext.request.contextPath}/users/delete?id=${user.userId}"
					class="btn btn-sm btn-danger" onclick="return confirm('삭제할까요?')">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>