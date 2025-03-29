<%@ include file="/WEB-INF/views/common/header.jsp"%>

<h2 class="mb-4">게시판 목록</h2>

<table class="table table-bordered table-hover">
	<thead class="table-secondary">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.boardId}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td><fmt:formatDate value="${board.createdAt}"
						pattern="yyyy-MM-dd HH:mm" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div class="mt-3 text-end">
	<a href="#" class="btn btn-primary">글쓰기</a>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
