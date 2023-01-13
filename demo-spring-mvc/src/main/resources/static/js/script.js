// Récupération des balises
var liElements = document.getElementsByTagName("li");
// Récupération de l'élément div
var resultElement = document.getElementById("result");
// Modification du contenu HTML de l'élément div pour afficher le nombre de balises li
resultElement.innerHTML = "Number of room : " + liElements.length;

//alert("Bonjour")