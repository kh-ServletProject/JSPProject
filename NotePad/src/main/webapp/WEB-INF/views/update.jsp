<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메모 수정하기</h2>
	<form action="/memo/update" method="post" id="updateForm">
		<div>
			<span>제목 : <input type="text" name="title" value="${memo.memoTitle}"></span> <br>
		</div>
		<div>
			<textarea rows="3" cols="50" name="content" placeholder="내용을 입력하세요">${memo.memoContent}</textarea>
		</div>
		<input type="hidden" name="memoNo" value="${param.memoNo}">
		<button>수정하기</button>
	</form>
</body>
</html>