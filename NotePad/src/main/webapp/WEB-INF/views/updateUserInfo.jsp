<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>
 <br>
    <h1>NOTE PAD 회원 정보 수정</h1>
    <form action="/isUser" method="post" id="isUserForm">
      <div class="isUser">
        비밀번호 입력 :
        <input type="password" name="memberPw" placeholder="비밀번호를 입력하세요 (영문,숫자가 한개이상포함)" required id="memberPw"/>
        <div style="text-align: right; border: none; box-shadow: none;">
        <button id="isRight" type="submit">확인</button>
        </div>
      </div>
    </form>

    <div id="updateForm" style="display: none;">
      <form action="/updateUser" method="post">
          <div>
              아이디: <input type="text" name="memberId" value="${loginMem.memberId}" /><br>
              이름: <input type="text" name="memberName" value="${loginMem.memberName}" /><br>
              새 비밀번호: <input type="password" name="memberPw" placeholder="새 비밀번호 입력" /><br>
              <div style="text-align: right; border: none; box-shadow: none;">
              <button type="submit">수정 완료</button>
            </div>
          </div>
      </form>
    </div>

<c:if test="${not empty sessionScope.message}">
    <script>
      alert("${message}");
    </script>

    <c:remove var="message" scope="session" />
</c:if>

<c:if test="${pwCheck}">
    <script>
      document.querySelector(".isUser").style.display = "none";
      document.getElementById("updateForm").style.display = "block";
    </script>
    <c:remove var="pwCheck" scope="session" />
</c:if>
<script src="/resources/js/updateUserInfo.js"></script>
</body>
</html>