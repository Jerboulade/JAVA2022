function onClick(){
    let elem = document.createElement("li");
    //let cpt = document.getElementById("listItem").childElementCount + 1
    elem.innerHTML = document.getElementById("userInput").value //"item" + cpt
    document.getElementById("listItem").appendChild(elem)
}
