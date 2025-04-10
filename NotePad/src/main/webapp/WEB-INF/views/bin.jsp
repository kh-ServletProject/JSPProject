<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>${ member.memberName }님의 휴지통</title>
<link rel ="stylesheet" href="/resources/css/detail.css">

</head>
<body>

	<div>
		<button type="button" id="allselect">전체선택</button>
	</div>
	<div>
		<table border=1>
			<thead>
				<tr>
					<th>선택</th>
					<th>번호</th>
					<th>제목</th>
					<th>생성 날짜</th>
					<th>수정 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="memo" items="${ requestScope.memoList }" varStatus="vs">
				<c:if test="${ memo.deleted.toString() == 'y'}">

					<tr>
						 <td><input type="checkbox" class="checkboxBin" name="memoNo" value="${memo.memoNo}"/></td>
						<td>${ memo.memoNo }</td>
						<td>${ memo.memoTitle }</td>
						<td>${ memo.writeDate }</td>
						<td>${ memo.updateDate }</td>
						
					</tr>
				</c:if>
				</c:forEach>
				<button id="deleteBtn">삭제</button>
			</tbody>
		</table>
	</div>

	<div>
		<button type="button" id="goMemoList">목록으로</button>
	</div>

  <script src="/resources/js/all.js"></script>
	<script src="/resources/js/detail.js"></script>
	<script src="/resources/js/bin.js"></script>

</body>
</html>