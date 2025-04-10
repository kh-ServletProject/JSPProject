const addMemo = document.querySelector("#addMemo");

addMemo.addEventListener("click", ()=>{

  location.href = "/addMemo";

});

const logoutBtn = document.querySelector("#logoutBtn");

logoutBtn.addEventListener("click", () => {
   
  location.href = "/logout";
});

// fullView.jsp 내의 input 태그
const searchInput = document.querySelector(".searchInput");

// input 태그에 keyup이 일어난 경우
searchInput.addEventListener("keyup", (e) => {
  // input 태그 내의 value 값
  let keyword = searchInput.value;
  const regExp = new RegExp(keyword);

  const tdList = document.querySelectorAll(".title");
  
  for(td of tdList) {

    // td 내부의 a 태그 내용
    const a = td.firstElementChild.innerHTML;
    
    if(!regExp.test(a)) {
      td.parentElement.style.display = "none";
    } else {
      td.parentElement.style.display = "table-row";
    }
  }

});