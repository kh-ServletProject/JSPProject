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