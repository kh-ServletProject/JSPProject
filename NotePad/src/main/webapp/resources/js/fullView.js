const addMemo = document.querySelector("#addMemo");

const multiSelect = document.querySelector("#multiSelect");
const checkboxes = document.querySelectorAll(".multiCheckbox");
const selectAllMemo = document.querySelector("#selectAllMemo");
const multiBin = document.querySelector("#multiBin");

let isVisible = false;

addMemo.addEventListener("click", ()=>{

  location.href = "/addMemo";

});


multiSelect.addEventListener("click", () => {
	isVisible = !isVisible;
  selectAllMemo.style.display = isVisible ? "inline-block" : "none";
  multiBin.style.display = isVisible ? "inline-block" : "none";
  
console.log(checkboxes.length);

  // for(checkbox of checkboxes){
  //   checkbox.style.display = isVisible ? "inline-block" : "none";
  //   checkbox.checked=isVisible;
  // }
  checkboxes.forEach(cb => {
    cb.style.display = isVisible ? "inline-block" : "none";
    cb.checked = isVisible;
  });

  // multiBin.addEventListener("click", () => {
  //   //const checkedBoxes = document.querySelectorAll(".multiCheckbox:checked");
  // });
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
  // keyword를 포함하는 문자열을 체크하기 위한 정규식 객체 생성
  const regExp = new RegExp(keyword);

  // title 클래스를 가진 모든 td를 가져옴
  const tdList = document.querySelectorAll(".title");
  
  for(td of tdList) {

    // td 내부의 a 태그 내용
    const a = td.firstElementChild.innerHTML;
    
    // 정규식으로 체크
    if(!regExp.test(a)) { // keyword 내용이 포함 X
      td.parentElement.style.display = "none";

    } else { // keyword 내용이 포함 O
      td.parentElement.style.display = "table-row";
    }
  }

});