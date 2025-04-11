<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>이김강장 메모장</title>
    <link rel="stylesheet" href="/resources/css/detail.css" />
  </head>

  <body>
    <div>
      <h1>이김강장 메모장</h1>
      <div>
        <form action="/login" method="post">
          <div>
            <span style="font-weight: bold;"
              >ID :
              <input
                type="text"
                name="memberId"
                required
                placeholder="ID를 입력해주세요."
            /></span>
          </div>
          <div>
            <span style="font-weight: bold;"
              >PW :
              <input
                type="password"
                name="memberPw"
                required
                placeholder="비밀번호를 입력해주세요."></span>
          </div>

          <div id="buttonGroup">
            <button id="loginBtn" type="submit">로그인</button>
            <button
              id="signupBtn"
              type="button"
              onclick="window.location.href='/signup'"
            >
              회원가입
            </button>
          </div>
        </form>
      </div>
    </div>

    <c:if test="${not empty sessionScope.message}">
      <script>
        alert("${message}");
      </script>
      <c:remove var="message" scope="session" />
    </c:if>

    <script src="/resources/js/all.js"></script>
    <script src="/resources/js/test.js"></script>
  </body>
</html>
