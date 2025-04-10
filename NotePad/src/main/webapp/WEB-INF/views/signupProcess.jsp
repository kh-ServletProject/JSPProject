<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>SignUp</title>
<link rel="stylesheet" href="/resources/css/detail.css">
  </head>

  <body>
    <h1>NOTE PAD 회원 가입</h1>
    <form action="/signup" method="post" id="signupForm">
      <div>
        생성할 ID : <input type="text" name="memberId" required id="memberId"/>
        <span id="idError" class="error"></span><br><br>
        비밀번호 입력 : <input type="password" name="memberPw" required id="memberPw"/>
        <span id="pwError" class="error"></span><br><br>
        이름 입력 : <input type="text" name="memberName" required />
        
      </div>

      <div id="buttonGroup">
        <button type="button" id="homeBtn">Home</button>
        <button id="signupBtn">회원가입하기</button>
      </div>
    </form>
    
    <script>
   
      document.getElementById("homeBtn").addEventListener("click", function () {
        window.location.href = "/"; // 메인 페이지 경로로 리다이렉트
      });

      const signupForm = document.getElementById("signupForm");
      const memberIdInput = document.getElementById("memberId");
      const memberPwInput = document.getElementById("memberPw");
      const idError = document.getElementById("idError");
      const pwError = document.getElementById("pwError");

      signupForm.addEventListener("submit", function (event) {
        let isValid = true;

        
        const idRegex = /^[a-zA-Z0-9]+$/;
        if (!idRegex.test(memberIdInput.value)) {
          isValid = false;
          idError.textContent = "ID는 영문과 숫자로만 이루어져야 합니다.";
        } else {
          idError.textContent = "";
        }

       
        const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d).+$/;
        if (!pwRegex.test(memberPwInput.value)) {
          isValid = false;
          pwError.textContent =
            "비밀번호는 영문과 숫자를 각각 최소 1개 이상 포함해야 합니다.";
        } else {
          pwError.textContent = "";
        }

      
        if (!isValid) {
          event.preventDefault();
        }
      });
    </script>
    

  
	<c:if test="${not empty sessionScope.message}">
  		<script>
  		
  			alert("${message}");
  		</script>
  		
  		<c:remove var="message" scope="session"/>
  	</c:if>

    <script src="/resources/js/all.js"></script>
    <script src="/resources/js/test.js"></script>
  </body>
</html>
