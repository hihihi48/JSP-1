<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!-- 오류 알림 -->
<c:if test="${not empty error}">
	<div class="alert alert-danger">${error}</div>
</c:if>

<div class="card">
	<div class="card-header">
		<h3 class="mb-0">
			<c:choose>
				<c:when test="${mode eq 'create'}">Register</c:when>
				<c:otherwise>Edit</c:otherwise>
			</c:choose>
			User
		</h3>
	</div>

	<div class="card-body">
		<form
			action="${pageContext.request.contextPath}/users/${mode eq 'create' ? 'create' : 'update'}"
			method="post">

			<c:if test="${mode eq 'edit'}">
				<input type="hidden" name="id" value="${user.userId}" />
			</c:if>

			<div class="mb-3">
				<label for="username" class="form-label">Username</label> <input
					type="text" name="username" id="username" class="form-control"
					value="${user.username}" required
					<c:if test="${mode eq 'edit'}">readonly</c:if> />
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Password</label> <input
					type="password" name="password" class="form-control"
					placeholder="Password" required />
			</div>

			<div class="mb-3">
				<label for="confirmPassword" class="form-label">Confirm
					Password</label> <input type="password" name="confirmPassword"
					class="form-control" placeholder="Confirm Password" required />
			</div>

			<div class="mb-3">
				<label for="nickname" class="form-label">Nickname</label> <input
					type="text" name="nickname" id="nickname" class="form-control"
					value="${user.nickname}" required />
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="${pageContext.request.contextPath}/users"
				class="btn btn-secondary">Cancel</a>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>