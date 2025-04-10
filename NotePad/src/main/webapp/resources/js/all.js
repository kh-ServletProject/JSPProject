const goMemoList = document.querySelector("#goMemoList");

document.addEventListener("DOMContentLoaded", () => {
  
  const addMemoButton = document.getElementById("addMemo");
  addMemoButton.addEventListener("mouseenter", () => {
    const tooltip = document.createElement("div");
    tooltip.id = "tooltip";
    tooltip.textContent = "메모 추가";
    tooltip.style.position = "absolute";
    tooltip.style.bottom = "90px";
    tooltip.style.right = "20px";
    tooltip.style.backgroundColor = "#333";
    tooltip.style.color = "white";
    tooltip.style.padding = "5px 10px";
    tooltip.style.borderRadius = "5px";
    tooltip.style.fontSize = "12px";
    tooltip.style.boxShadow = "0 2px 4px rgba(0, 0, 0, 0.2)";
    document.body.appendChild(tooltip);
  });

  addMemoButton.addEventListener("mouseleave", () => {
    const tooltip = document.getElementById("tooltip");
    if (tooltip) tooltip.remove();
  });

  // Smooth scroll to top when "목록으로" button is clicked
  const goMemoListButton = document.getElementById("goMemoList");
  if (goMemoListButton) {
    goMemoListButton.addEventListener("click", () => {
      window.scrollTo({ top: 0, behavior: "smooth" });
    });
  }
});

goMemoList.addEventListener("click", () => {

	location.href = "/login";

});