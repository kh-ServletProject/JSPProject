const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click", ()=> {

  if(!confirm("정말 삭제하시겠습니까?")) return;

  location.href = "/memo/delete?memoNo=" + todoNo;
});

