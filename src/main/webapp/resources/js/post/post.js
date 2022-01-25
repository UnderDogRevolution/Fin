console.log("post.js");

const like1 = document.querySelectorAll(".container-like > img")[0];
const like2 = document.querySelectorAll(".container-like > img")[1];

like1.addEventListener("click", function(){
	like1.style.display = "none";
	like2.style.display = "block";
})

like2.addEventListener("click", function(){
	like1.style.display = "block";
	like2.style.display = "none";
})









