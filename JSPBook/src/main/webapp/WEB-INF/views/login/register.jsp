<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- Bootstrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card shadow-sm">
					<div class="card-body">
						<h3 class="card-title mb-4 text-center">회원가입</h3>

						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>

						<form action="${pageContext.request.contextPath}/register/submit"
							method="post">
							<div class="mb-3">
								<label for="username" class="form-label">아이디</label> <input
									type="text" class="form-control" id="username" name="username"
									required />
							</div>

							<div class="mb-3">
								<label for="password" class="form-label">비밀번호</label> <input
									type="password" class="form-control" id="password"
									name="password" required />
							</div>

							<div class="mb-3">
								<label for="confirmPassword" class="form-label">비밀번호 확인</label>
								<input type="password" class="form-control" id="confirmPassword"
									name="confirmPassword" required />
							</div>

							<div class="mb-3">
								<label for="nickname" class="form-label">닉네임</label> <input
									type="text" class="form-control" id="nickname" name="nickname"
									required />
							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">회원가입</button>
							</div>
						</form>

						<div class="mt-3 text-center">
							<a href="${pageContext.request.contextPath}/login/form">로그인으로
								돌아가기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
