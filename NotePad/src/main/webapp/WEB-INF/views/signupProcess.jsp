<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>SignUp</title>
  </head>
  <body>
    <h1>NOTE PAD 회원 가입</h1>
    <form action="/signup" method="post">
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
   
    <script>
        // Home 버튼 클릭 시 메인 페이지로 이동
        document.getElementById("homeBtn").addEventListener("click", function() {
            window.location.href = "/"; // 메인 페이지 경로로 리다이렉트
        });
    </script>
    

  
	<c:if test="${not empty sessionScope.message}">
  		<script>
  		
  			alert("${message}");
  		</script>
  		
  		<c:remove var="message" scope="session"/>
  	</c:if>

    <script src="/resources/js/test.js"></script>
  </body>
</html>
