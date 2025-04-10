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

	<div id="viewContainer">
		<div id="search">
			<input type="text" class="searchInput" placeholder="검색할 제목을 입력하세요.">
		</div>
		<div id="content">
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
						<c:if test="${ memo.deleted.toString() == 'n' }">
							<tr>
								<td>${ memo.memoNo }</td>
								<td class="title"><a href="/memo/detail?memoNo=${ memo.memoNo }">${ memo.memoTitle }</a></td>
								<td>${ memo.writeDate }</td>
								<td>${ memo.updateDate }</td>
								<%-- <td>${ memo.deleted }</td> --%>
							</tr>
						</c:if>
					</c:forEach>
          
          <form action="/memo/bin" method="post">
				<div><button id="bin">휴지통</button></div>
				</form>
          
				</tbody>
			</table>
		</div>
		<div id="info">
			<div class="memberName"><span>${ member.memberName }</span></div>
			<div class="memberLogout"><button id="logoutBtn">로그아웃</button></div>
		</div>
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