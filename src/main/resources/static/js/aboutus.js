
const body = document.querySelector("body");
const darkmode = document.querySelector("#darkmode");
const lightmode = document.querySelector("#lightmode");

function setDarkMode(){
    body.style.backgroundColor="black";
    body.style.color="white";
}

function setLightMode(){
    body.style.backgroundColor="white";
    body.style.color="black";
}

darkmode.addEventListener('click',setDarkMode);
lightmode.addEventListener('click',setLightMode);





