<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/phonebook.css' />">
<title>전화번호부</title>
</head>
<body>

	<h2>주소록 Web</h2>
	<h3>목록 (검색어: ${ param.keyword } )</h3>
	<form id="search-form">

		<label for="keyword">검색어</label> <input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<a href="<c:url value='/' />">전체 목록</a>
	<table id="phonebook" width="640" border="1">
		<tr>
			<th class="col_name">이름</th>
			<th class="col_phone">휴대전화</th>
			<th class="col_phone">전화번호</th>
			<th class="col_toolbar">도구</th>
		</tr>

		<c:forEach items="${ list }" var="vo">
			<tr>
				<td>${ vo.name }</td>
				<td>${ vo.hp }</td>
				<td>${ vo.tel }</td>
				<td>
					<form method="POST" action="<c:url value='/delete' />/${vo.id}">
						<button type="submit">삭제</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<p>

		<a href="<c:url value='/add' />">새 주소 추가</a>
</body>
</html>