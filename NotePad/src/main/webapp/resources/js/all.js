document.addEventListener("DOMContentLoaded", function() {
  // Add tooltip for the addMemo button
  const addMemoButton = document.getElementById("addMemo");
  const addMemoTooltip = document.createElement("div");
  addMemoTooltip.textContent = "메모 추가하기";
  addMemoTooltip.id = "tooltip-addMemo";
  document.body.appendChild(addMemoTooltip);

  addMemoButton.addEventListener("mouseenter", function(event) {
      const rect = addMemoButton.getBoundingClientRect();
      addMemoTooltip.style.left = `${rect.left + window.scrollX}px`;
      addMemoTooltip.style.top = `${rect.top + window.scrollY - addMemoTooltip.offsetHeight - 50}px`;
      addMemoTooltip.style.display = "block";
  });

  addMemoButton.addEventListener("mouseleave", function() {
      addMemoTooltip.style.display = "none";
  });

  // Add tooltip for the bin2 button
  const bin2Button = document.getElementById("bin2");
  const bin2Tooltip = document.createElement("div");
  bin2Tooltip.textContent = "휴지통 보기";
  bin2Tooltip.id = "tooltip-bin";
  document.body.appendChild(bin2Tooltip);

  bin2Button.addEventListener("mouseenter", function(event) {
      const rect = bin2Button.getBoundingClientRect();
      bin2Tooltip.style.left = `${rect.left + window.scrollX}px`;
      bin2Tooltip.style.top = `${rect.top + window.scrollY - bin2Tooltip.offsetHeight - 50}px`;
      bin2Tooltip.style.display = "block";
  });

  bin2Button.addEventListener("mouseleave", function() {
      bin2Tooltip.style.display = "none";
  });
});