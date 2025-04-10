<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>SignUp</title>
  </head>
  <body>
    <h1>NOTE PAD 회원 가입</h1>
    <form action="/signupProcess" method="post">
      <div>
        생성할 ID : <input type="text" name="memberId" required /> 비밀번호 입력
        :<input type="password" name="memberPw" required /> 이름 입력 :
        <input type="text" name="memberName" required />
      </div>

      <div>
        <button>회원가입하기</button>
      </div>
    </form>
    <button id="homeBtn">Home</button>

   
    <c:if test="${not empty sessionScope.message}">
      <script>
        alert("${sessionScope.mes}");
      </script>
      <c:remove var="mes" scope="session" />
    </c:if>

    <script src="/resources/js/test.js"></script>
  </body>
</html>
