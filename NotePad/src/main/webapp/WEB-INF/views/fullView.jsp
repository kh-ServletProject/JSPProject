<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ member.memberName }님의 메모장</title>
<link rel ="stylesheet" href="/resources/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">


</head>
<body>

	<div id="viewContainer">
		<div id="mainContent">

		<div id="search">
			<input type="text" class="searchInput" placeholder="검색할 제목을 입력하세요.">
		</div>
		<div id="content">

			<table border=1 id="hidetr">
				<thead>
					<tr>
						<th id="selectAllMemo"  style="display:none;"><input id="checkAll" type="checkbox" >선택</th>
						<th id="numberHeader">번호</th>
						<th>제목</th>
						<th>생성 날짜</th>
						<th>수정 날짜</th>
						<%-- <th>삭제 여부</th> --%>
					</tr>

				</thead>
				<tbody>
					<form action="/memo/multiBin" method="post" id="multiBinForm">
						<c:forEach var="memo" items="${ requestScope.memoList }" varStatus="vs">
	
						<c:if test="${memo.deleted.toString() == 'n'}">
	
							<tr>
								<td class="chkTd" style="display:none;"><input class="chekedStatus" type="checkbox" name="memoNo" value="${memo.memoNo}" ></td>
								<td>${ memo.memoNo }</td>
	
								<td class="title"><a href="/memo/detail?memoNo=${ memo.memoNo }">${ memo.memoTitle }</a></td>
								<td>${ memo.writeDate }</td>
								<td>${ memo.updateDate }</td>
							</tr>
							</c:if>
						</c:forEach>
	         			<button id="multiBin" style="display:none;">휴지통에버리기</button>
	          		</form>
	          	<button id="multiSelect">여러 항목 삭제</button>
	         	 
				<form action="/memo/bin" method="post">
					<button id="bin"></button>
				</form>
	          
			</tbody>
			</table>
		</div>
		</div>
		<div id="info">
			<div class="memberName">
				<span>${ member.memberName }</span>
			</div>
			<div class="memberLogout">
				<button id="logoutBtn">로그아웃</button>
			</div>
		</div>
		<form action="/memo/bin" method="post">
		<button id="bin"><i class="fa-solid fa-trash"></i></button>
	  </form>
	
	  <form action="/addMemo">
		 <button id="addMemo"><i class="fa-regular fa-square-plus"></i></button>
	   </form>
		
	</div>

	

	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>

<script>

document.getElementById('multiSelect').addEventListener('click', function () {
 
  document.querySelectorAll('.multiCheckbox, #multiBin, #selectAllMemo').forEach(el => {
    el.style.display = 'table-cell'; 
  });
  
 
  document.querySelectorAll('.multiCheckbox').forEach(el => {
    el.style.textAlign = 'center'; 
    el.style.verticalAlign = 'middle'; 
  });
});
</script>
		

		<c:remove var="message" scope="session" />
	</c:if>
  <script src="/resources/js/all.js"></script>
	<script src="/resources/js/fullView.js"></script>
</body>
</html>