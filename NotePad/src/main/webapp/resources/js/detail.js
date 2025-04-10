const deleteBtn = document.querySelector("#deleteBtn");
const goMemoList = document.querySelector("#goMemoList");
const memoNo = new URLSearchParams(location.search).get("memoNo");
const memberId = new URLSearchParams(location.search).get("memberId");
const updateBtn = document.querySelector("#updateBtn");
const memoNo = new URLSearchParams(location.search).get("memoNo");
const goBinBtn = document.querySelector("#goBinBtn");


goMemoList.addEventListener("click", () => {
  
  location.href = "/login";
  
});

goBinBtn.addEventListener("click", () => {

  location.href = "/memo/gobin?memoNo=" + memoNo;
  
});
deleteBtn.addEventListener("click", ()=> {

  if(!confirm("완전히 삭제하시겠습니까?")) return;

  location.href = "/memo/delete?memoNo=" + memoNo;
});

deleteBtn.addEventListener("click", ()=> {

  if(!confirm("정말 삭제하시겠습니까?")) return;

  location.href = "/memo/delete?memoNo=" + memoNo;
});

updateBtn.addEventListener("click", ()=> {
  location.href = "/memo/update?memoNo=" + memoNo;
});