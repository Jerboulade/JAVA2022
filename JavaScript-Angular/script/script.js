// let x =  3 + 3 + "3";
// let y = "23"
// console.log(x + y);
// //alert("Hello World");
// let s1 = ("é");
// console.log(s1.charCodeAt(0) + String.fromCharCode(1234));

// let str = "ma formation javascript";
// console.log("-----------------------\n" + str + "\n-----------------------\n");
// console.log("Position de 'ma' : " + str.indexOf("ma"));
// console.log("Indice de 'p' : " + str.indexOf("p"));
// console.log("Lettre a l'indice 21 : " + str.charAt(21));
// console.log("Remplacer 'javascript' par 'Java' -> " + str.replace("javascript", "Java"));
// console.log(str.split(" "));
// console.log("Reverse : " + str.split("").reverse().join(""));

// let prix = prompt("Prix unitaire : ");
// let qty = prompt("Quantité de livre(s) : ");
// alert("Prix TTC = " + (prix * qty *1.21));

//console.log("Bonjour, nous sommes " + new Date().toLocaleString('default', {weekday: 'long'}));

// function f(str) {
//     str = str.split("").reverse().join("");
//     console.log(str);
// }
// s = "coucou petite perruche"
// f(s);
// console.log(s);

// document.write("<p>coucou</p>")

// let elem = document.getElementById("lorem");
// console.log(elem);

// let elem = document.getElementsByClassName("h2");
// console.log(elem[0]);
// // -->marche pas

// let elem = document.createElement("li")
// elem.innerHTML = "first item"
// let item = document.getElementById("lorem")
// item.appendChild(elem)
// console.log(elem)

// ----------------------


function onClick(){
    let elem = document.createElement("li");
    //let cpt = document.getElementById("listItem").childElementCount + 1
    elem.innerHTML = document.getElementById("userInput").value //"item" + cpt
    document.getElementById("listItem").appendChild(elem)
}

let sum = 0;
function addPrice(index){
    let row = document.getElementById("tab").children[0].children[index]
    console.log(row)

    let art = row.children[0].innerHTML
    let prix = row.children[1].innerHTML
    //console.log(art + " " + prix)


    let newrow = document.createElement("tr")
    let newart = document.createElement("th")
    newart.innerHTML = art
    let newprix = document.createElement("td")
    newprix.innerHTML = prix

    sum += parseInt(prix)
    document.getElementById("sommePrice").innerHTML = sum

    newrow.appendChild(newart)
    newrow.appendChild(newprix)

    let tabtab = document.getElementById("panier")
    tabtab.children[1].insertBefore(newrow, document.getElementById("somme"))
}
    // ----------------------

    // hello = () => {
    //     alert("Hello")
    // }

    // setTimeout(() => {hello()}, 3000)
    // setInterval(() => {hello()}, 3000)

    // ----------------------

    refreshHour = () => {
        let date = new Date()
        hour.innerHTML = date.getHours() + ' : ' + date.getMinutes() + ' : ' + date.getSeconds() + ' : ' + date.getMilliseconds()
    }
    let hour = document.createElement('h1')
    refreshHour()
    document.body.appendChild(hour)
    //document.title = hour.innerHTML
    setInterval(() => {refreshHour()}, 1)

    // ----------------------

    let btn = document.getElementById("btn").addEventListener("mouseover", () => {
        console.log("Mouse over !")
    })


    // ----------------------

    nb = [1,2,3,4,5,6]
    nb2 = nb.map(n => { // 'map' return undefined if doesn't enter the condition, 'filter' not
        if (n % 2 == 0)
            return n
    })
    
    console.log(nb2)

    // ----------------------

    let myObj = [{
        id : 238,
        name : "Paul",
        lastname : "Nordine"
    },{
        id : 239,
        name : "Jean",
        lastname : "Nérienafoutre"
    },{
        id : 240,
        name : "Caroline",
        lastname : "Pique"
    }]

    let mapped = myObj.map((o) => { 
        if (o.lastname != ''){
            return {
        name : o.name,
        lastname : o.lastname,
        mnemonique : o.name.substring(0,2) + o.lastname.substring(0,3)

    }}})
    console.log(mapped);

    // ----------------------

    class myClass{
        id
        name
        lastname
        constructor(id, name, lastname){
            this.id = id
            this.name = name
            this.lastname = lastname
        }
    }
    let object = new myClass(12, "Lio", "Philipé")
    console.log(object)

    // ----------------------

    