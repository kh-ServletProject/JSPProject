const deleteBtn = document.querySelector("#deleteBtn");
const goMemoList = document.querySelector("#goMemoList");
const memoNo = new URLSearchParams(location.search).get("memoNo");
const memberId = new URLSearchParams(location.search).get("memberId");


goMemoList.addEventListener("click", () => {
  
  location.href = "/login";
  
});


// 삭제 여부 변경
const goBinBtn = document.querySelector("#goBinBtn");

goBinBtn.addEventListener("click", () => {
  
  console.log("test js")
  location.href = "/memo/gobin?memoNo=" + memoNo;
  
  
});
deleteBtn.addEventListener("click", ()=> {

  if(!confirm("완전히 삭제하시겠습니까?")) return;

  location.href = "/memo/delete?memoNo=" + memoNo;
});