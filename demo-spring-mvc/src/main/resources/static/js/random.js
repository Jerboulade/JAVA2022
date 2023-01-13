console.log("coucou");

function goRef(){
    console.log("coucou2");
    var href = document.getElementById("getRef").href;
    var elem = document.getElementById("getRef")
    console.log(href);

    var number = document.getElementById("rand").value;
    elem.setAttribute('href', href + number);
    console.log(number);
    console.log(document.getElementById("getRef").href);

}