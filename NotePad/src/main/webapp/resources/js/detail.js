const goMemoList = document.querySelector("#goMemoList");
const memoNo = new URLSearchParams(location.search).get("memoNo");
const memberId = new URLSearchParams(location.search).get("memberId");
const updateBtn = document.querySelector("#updateBtn");
const goBinBtn = document.querySelector("#goBinBtn");

goMemoList.addEventListener("click", () => {

	location.href = "/login";

});

goBinBtn.addEventListener("click", () => {
	
			location.href = "/memo/gobin?memoNo=" + memoNo;
	
});


updateBtn.addEventListener("click", () => {
	
			location.href = "/memo/update?memoNo=" + memoNo;
	
			
	
});

