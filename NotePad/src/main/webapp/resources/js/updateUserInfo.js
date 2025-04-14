document.getElementById("homeBtn").addEventListener("click", function () {
    location.href = "/login" // fullView 페이지로 리다이렉트
  });

// 비밀번호를 입력 해 맞으면 회원 정보를 수정하게 함
document.querySelector("#isRight").addEventListener("click", (e) => {
    
    document.querySelector("#isUserForm").submit();
    
});