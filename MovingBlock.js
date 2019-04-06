var IntervalMovement;
var elementDiv = undefined;
var increment = 100;
window.onload = function () {
    elementDiv = document.getElementById("leftCorner");
    IntervalMovement = setInterval(moveRight, 10);
};

function moveRight(){
    increment++;
    console.log("Bannaa");
    elementDiv.style.left =increment + "px";

    if(increment === 1600){
        clearInterval(IntervalMovement);
    }
}