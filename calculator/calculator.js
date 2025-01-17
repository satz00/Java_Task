const display = document.getElementById('display');
const buttons = document.querySelectorAll('button');

let currentInput = '';
let operator = null;
let firstOperand = null;

buttons.forEach(button => {
  button.addEventListener('click', () => {
    const value = button.textContent;

    if (value === 'C') {
      currentInput = '';
      operator = null;
      firstOperand = null;
      display.value = '';
      display.style.fontSize = "28px"; 
      return;
    }

    if (value === '=') {
      if (operator && firstOperand !== null) {
        const secondOperand = parseFloat(currentInput);
        switch (operator) {
          case '+': currentInput = (firstOperand + secondOperand).toString(); break;
          case '-': currentInput = (firstOperand - secondOperand).toString(); break;
          case '*': currentInput = (firstOperand * secondOperand).toString(); break;
          case '/': currentInput = (firstOperand / secondOperand).toString(); break;
        }
        operator = null;
        firstOperand = null;
        display.value = currentInput;
        adjustFontSize();
      }
      return;
    }

    if (['+', '-', '*', '/'].includes(value)) {
      if (currentInput) {
        firstOperand = parseFloat(currentInput);
        operator = value;
        currentInput = '';
      }
      return;
    }

    currentInput += value;
    display.value = currentInput;
    adjustFontSize();
  });
});


function adjustFontSize() {
  const maxLength = 10; 
  if (display.value.length > maxLength) {
    display.style.fontSize = "20px"; 
  } else if (display.value.length <= 2) {
    display.style.fontSize = "28px";
  } else {
    display.style.fontSize = "24px"; 
  }
}

