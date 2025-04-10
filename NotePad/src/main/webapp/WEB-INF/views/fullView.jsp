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
		<div id="veiwContent">
			<table border=1>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>생성 날짜</th>
						<th>수정 날짜</th>
						<%-- <th>삭제 여부</th> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="memo" items="${ requestScope.memoList }" varStatus="vs">
						<tr>
							<td>${ memo.memoNo }</td>
							<td><a href="/memo/detail?memoNo=${ memo.memoNo }">${ memo.memoTitle }</a></td>
							<td>${ memo.writeDate }</td>
							<td>${ memo.updateDate }</td>
							<%-- <td>${ memo.deleted }</td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="viewInfo">
			<div class="memberName"><span>${ member.memberName }</span></div>
			<div class="memberLogout"><button id="logoutBtn">로그아웃</button></div>
		</div>
	</div>
	
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>
		
		<c:remove var="message" scope="session"/>
	</c:if>		
	
	<script src="/resources/js/logout.js"></script>
</body>
</html>