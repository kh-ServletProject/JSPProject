const deleteBtn = document.querySelector("#deleteBtn");
const updateBtn = document.querySelector("#updateBtn");
const memoNo = new URLSearchParams(location.search).get("memoNo");
deleteBtn.addEventListener("click", ()=> {

  if(!confirm("정말 삭제하시겠습니까?")) return;

  location.href = "/memo/delete?memoNo=" + memoNo;
});

updateBtn.addEventListener("click", ()=> {
  location.href = "/memo/update?memoNo=" + memoNo;
});
