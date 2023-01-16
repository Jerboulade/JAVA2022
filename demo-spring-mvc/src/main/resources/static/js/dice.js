// Get the die element
const die = document.querySelector('.die');
// Get the input element where the result will be displayed
const result = document.querySelector('#rand');
// Add an event listener to the die element to roll the dice when clicked
die.addEventListener('click', rollDie);
// Function to roll the dice
function rollDie() {
    // Generate a random number between 1 and 6
    const randomNumber = Math.floor(Math.random() * 6) + 1;

    // Add the class corresponding to the randomly generated number
    die.classList.add(`show-face-${randomNumber}`);

    // Wait for the animation to complete before removing the class
    setTimeout(() => {
      die.classList.remove(`show-face-${randomNumber}`);
    }, 9000);

    // Display the result in the input element
    result.value = randomNumber;
}





