
/*setTimeout(function(){
        window.location.href = "../Welcome.jsp";
}, 5000);*/

// 

var url = (window.location).toString();
// console.log(url.search("member"));

var home = document.getElementById("home");
var navLink1 = document.getElementById("nav-link1");
var navLink2 = document.getElementById("nav-link2");
var navLink3 = document.getElementById("nav-link3");
var navLink4 = document.getElementById("nav-link4");


if (url.search("member") !== -1) {
	console.log(1);
	// 이 방식은 맘에 안 듦
	navLink1.addEventListener("click", () => {
		history.pushState(null, null, '../books.jsp');
		//window.location.href = "../books.jsp";
	});
	
	navLink2.addEventListener("click", () => {
		history.pushState(null, null, '../books.jsp');	
	});
	
	navLink3.addEventListener("click", () => {
		history.pushState(null, null, '../books.jsp');	
	});
	
	navLink4.addEventListener("click", () => {
		history.pushState(null, null, '../books.jsp');	
	});
	
	home.addEventListener("click", () => {
		history.pushState(null, null, '../books.jsp');	
	});
}


