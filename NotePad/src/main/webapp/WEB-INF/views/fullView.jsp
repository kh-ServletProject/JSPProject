<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ member.memberName }님의 메모장</title>
</head>
<body>

	<div>
		<table border=1>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>생성 날짜</th>
					<th>수정 날짜</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="memo" items="${ requestScope.memoList }" varStatus="vs">
					<tr>
						<td>${ memo.memoNo }</td>
						<td><a href="/memo/detail?memoNo=${ memo.memoNo }">${ memo.memoTitle }</a></td>
						<td>${ memo.writeDate }</td>
						<td>${ memo.updateDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<button id="addMemo">MEMO추가</button>
		
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>
		
		<c:remove var="message" scope="session"/>
	</c:if>
	<script src="/resources/js/fullView.js"></script>
</body>
</html>