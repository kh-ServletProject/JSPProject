<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${memo.memoTitle} 상세조회</title>
</head>
<body>

	<h1>${sessionScope.member.memberName}</h1>

	<h1>${memo.memoTitle}</h1>

	<div class="content">${memo.memoContent}</div>

	<div class="btn-box">
		<div>
			<button type="button" id="goMemoList">목록으로</button>
		</div>

		<div>
			<button id="updateBtn">수정</button>
			<button id="goBinBtn">휴지통으로 보내기</button>
		</div>

	</div>
	
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>
		
		<c:remove var="message" scope="session"/>
	</c:if>
	
<script src="/resources/js/detail.js"></script>
</body>
</html>