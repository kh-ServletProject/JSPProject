const addMemo = document.querySelector("#addMemo");

const multiSelect = document.querySelector("#multiSelect");
const checkTds = document.querySelectorAll(".chkTd"); // 체크되는 각 행
const chekedStatus = document.querySelectorAll(".chekedStatus");
const selectAllMemo = document.querySelector("#selectAllMemo"); // 선택
const multiBin = document.querySelector("#multiBin");
const checkAll  = document.querySelector("#checkAll"); //선택 체크박스

let isVisible = false;

addMemo.addEventListener("click", ()=>{

  location.href = "/addMemo";

});

// 여러 항목 삭제 선택 시 
multiSelect.addEventListener("click", () => {
	isVisible = !isVisible;
  selectAllMemo.style.display = isVisible ? "flex" : "none";
  multiBin.style.display = isVisible ? "flex" : "none";
  checkAll.style.display = isVisible ? "flex" : "none";

  // 모든 메모 체크박스 항목들 받아와서 화면에 보임/숨김 설정
  checkTds.forEach(chkTd => {
    chekedStatus.forEach(chk => {
      chk.checked = false; // 숨길 때만 체크 해제
      checkAll.checked = false;
    });
    chkTd.style.display = isVisible ? "flex" : "none";

  });
  
  // 버튼 토글
  multiSelect.textContent = isVisible? "취소" : "여러 항목 삭제"
});

const logoutBtn = document.querySelector("#logoutBtn");

logoutBtn.addEventListener("click", () => {
	

  location.href = "/logout";
});

// 메모 모두 선택(체크박스 체크)
selectAllMemo.addEventListener("click", () => {
  // isVisible = !isVisible;
  checkAll.checked = !isVisible;

  chekedStatus.forEach(chk => {
    chk.checked = isVisible;
  });
  
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

