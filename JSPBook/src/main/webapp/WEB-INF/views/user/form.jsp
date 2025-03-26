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
	<h2>
		<c:if test="${mode eq 'create'}">Register</c:if>
		<c:if test="${mode eq 'edit'}">Edit</c:if>
		User
	</h2>

	<form
		action="${pageContext.request.contextPath}/users/${mode eq 'create' ? 'create' : 'update'}"
		method="post">

		<c:if test="${mode eq 'edit'}">
			<input type="hidden" name="id" value="${user.userId}" />
		</c:if>

		<input type="text" name="username" placeholder="Username"
			value="${user.username}"
			<c:if test="${mode eq 'edit'}">readonly</c:if> required /><br />
			
			<input
			type="password" name="password" placeholder="Password"
			value="${user.password}" required /><br /> <input type="text"
			name="nickname" placeholder="Nickname" value="${user.nickname}"
			required /><br />
		<button type="submit">Submit</button>
	</form>
</body>
</html>