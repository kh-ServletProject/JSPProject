<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <h1>${ member.memberName }님 의 메모장 추가</h1>

<form action="/addMemo" method="post">
	<div>
		제목 : <input type="text" name="memoTitle" required ><br>
		내용 : <textarea rows="8" cols="8" name="memoContent" placeholder="상세내용을 작성해주세요" required></textarea><br>
	</div>
	
	<button>완료</button>
</form>

	<c:if test="${not empty sessionScope.message}">
  		
  		<script>
  			alert("${message}");
  		</script>
  		
  		<c:remove var="message" scope="session"/>
  	</c:if>

</body>
</html>