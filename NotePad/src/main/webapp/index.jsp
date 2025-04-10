<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>이김강장 메모장</title>
</head>
<body>
	<div>
		<h1>이김강장 메모장</h1>
			<div>
			<form action="/login" method="post">
				<div><span>ID : <input type="text" name="memberId" required> </span> </div>
				<div><span>PW : <input type="password" name="memberPw" required></span> </div>

				<div><button>로그인</button> </div>
			</form>
		</div>
	</div>
	<button id="signupBtn">회원가입</button>
  
	<c:if test="${not empty requestScope.message}">
		<script>
			alert("${message}");
		</script>
		
		<c:remove var="message" scope="request"/>
	</c:if>	
 
	<script src="/resources/js/test.js"></script>
</body>
</html>

