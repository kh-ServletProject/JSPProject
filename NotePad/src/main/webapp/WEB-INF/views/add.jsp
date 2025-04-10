<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="/resources/css/detail.css">
</head>
<body>
      

			<form action="/addMemo" method="post">
				<div id="formContainer">
					<h3><span class="memberName">${ member.memberName }님 의 메모장 추가</span></h3>
					<div class="form-group">
						<label for="memoTitle">제목:</label>
						<input type="text" id="memoTitle" name="memoTitle" required>
					</div>
					<div class="form-group">
						<label for="memoContent">내용:</label>
						<textarea id="memoContent" rows="4" cols="20" name="memoContent" placeholder="상세 내용을 작성해주세요" required></textarea>
					</div>
					<div id="buttonGroup">
						<button type="submit" id="submitBtn" class="btn-group-item">완료</button>
						<button type="button" id="goMemoList" class="btn-group-item">목록으로</button>
				</div>
				</div>
			</form>
		
			<c:if test="${not empty sessionScope.message}">
				<script>
					alert("${message}");
				</script>
				<c:remove var="message" scope="session"/>
			</c:if>
		
			
		</body>
		</html>