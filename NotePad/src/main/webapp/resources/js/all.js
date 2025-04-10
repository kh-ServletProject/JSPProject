document.addEventListener("DOMContentLoaded", () => {
  const addMemoButton = document.getElementById("addMemo");
  const binButton = document.getElementById("bin");

  // 메모 추가 버튼 툴팁
  addMemoButton.addEventListener("mouseenter", (event) => {
    const tooltip = document.createElement("div");
    tooltip.id = "tooltip-addMemo";
    tooltip.textContent = "메모 추가";
    tooltip.style.position = "absolute";
    tooltip.style.top = `${event.target.getBoundingClientRect().top - 50}px`; // 버튼 위로 50px
    tooltip.style.left = `${
      event.target.getBoundingClientRect().left +
      event.target.offsetWidth / 2 -
      40
    }px`; // 중앙 정렬
    tooltip.style.backgroundColor = "#333";
    tooltip.style.color = "white";
    tooltip.style.padding = "5px 10px";
    tooltip.style.borderRadius = "5px";
    tooltip.style.fontSize = "12px";
    tooltip.style.boxShadow = "0 2px 4px rgba(0, 0, 0, 0.2)";
    tooltip.style.zIndex = "1000";
    document.body.appendChild(tooltip);
  });

  addMemoButton.addEventListener("mouseleave", () => {
    const tooltip = document.getElementById("tooltip-addMemo");
    if (tooltip) tooltip.remove();
  });

  // 휴지통 버튼 툴팁
  binButton.addEventListener("mouseenter", (event) => {
    const tooltip = document.createElement("div");
    tooltip.id = "tooltip-bin";
    tooltip.textContent = "휴지통으로";
    tooltip.style.position = "absolute";
    tooltip.style.top = `${event.target.getBoundingClientRect().top - 50}px`; // 버튼 위로 50px
    tooltip.style.left = `${
      event.target.getBoundingClientRect().left +
      event.target.offsetWidth / 2 -
      40
    }px`; // 중앙 정렬
    tooltip.style.backgroundColor = "#333";
    tooltip.style.color = "white";
    tooltip.style.padding = "5px 10px";
    tooltip.style.borderRadius = "5px";
    tooltip.style.fontSize = "12px";
    tooltip.style.boxShadow = "0 2px 4px rgba(0, 0, 0, 0.2)";
    tooltip.style.zIndex = "1000";
    document.body.appendChild(tooltip);
  });

  binButton.addEventListener("mouseleave", () => {
    const tooltip = document.getElementById("tooltip-bin");
    if (tooltip) tooltip.remove();
  });
});
