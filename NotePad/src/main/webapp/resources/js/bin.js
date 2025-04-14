const deleteBtn = document.querySelector("#deleteBtn");
const allselect = document.querySelector("#allselect");
const rollbackBtn = document.querySelector("#rollbackBtn");

deleteBtn.addEventListener("click", () => {

	const checkboxes = document.querySelectorAll(".checkboxBin:checked");

	if (checkboxes.length === 0) {
		alert("삭제할 항목을 선택하세요.");
		return;
	}

	// 확인창
	if (confirm("선택한 메모를 삭제하시겠습니까?")) {
		location.href = "/memo/delete";
	}
});

const checkboxBin = document.querySelectorAll(".checkboxBin");

let isChecked = false;

allselect.addEventListener("click", () => {
	isChecked = !isChecked;

	checkboxBin.forEach(chk => {
		chk.checked = isChecked;
	});

	allselect.textContent = isChecked ? "전체 해제" : "전체 선택";
});

rollbackBtn.addEventListener("click", function() {

	const checkboxes = document.querySelectorAll(".checkboxBin:checked");

	if (checkboxes.length === 0) {
		alert("복구할 항목을 선택하세요.");
		return;
	}

	// 확인창
	if (confirm("선택한 메모를 복구하시겠습니까?")) {
		location.href = "/memo/rollback";
	}
});