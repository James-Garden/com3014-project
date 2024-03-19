const button = document.querySelector(".select__button");
const dropdown = document.querySelector(".select__dropdown");
const options = document.querySelectorAll(".search__option");

button.addEventListener("click", () => {
  const expanded = button.getAttribute("aria-expanded") === "true" || false;
  button.setAttribute("aria-expanded", !expanded);
  dropdown.classList.toggle("show");
});

document.addEventListener("click", function (event) {
  if (!button.contains(event.target) && !dropdown.contains(event.target)) {
    dropdown.classList.remove("show");
    button.setAttribute("aria-expanded", "false");
  }
});

options.forEach((option) => {
  option.addEventListener("click", function () {
    const text = option.querySelector(".option__text").innerText;
    document.querySelector(".selected-value").innerText = text;
    dropdown.classList.remove("show");
    button.setAttribute("aria-expanded", "false");
    // redirect
    setTimeout(function() {
      window.location.href = "./../recipie-results/index.html";
    }, 1000);
  });
});
