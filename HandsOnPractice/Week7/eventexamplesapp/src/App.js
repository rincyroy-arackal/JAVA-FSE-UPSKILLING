import React, { useState } from "react";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);
  const [rupees, setRupees] = useState("");
  const [euros, setEuros] = useState("");

  // For Increment
  const handleIncrement = () => {
    setCount(prev => prev + 1);
    sayHello();
  };

  const sayHello = () => {
    console.log("Hello! This is a static message.");
  };

  // For Decrement
  const handleDecrement = () => {
    setCount(prev => prev - 1);
  };

  // For Say Welcome with argument
  const sayWelcome = (msg) => {
    alert(`Welcome message: ${msg}`);
  };

  // Synthetic event handler
  const handleClick = (e) => {
    e.preventDefault(); // synthetic event
    alert("I was clicked!");
  };

  // Currency Converter
  const handleSubmit = (e) => {
    e.preventDefault();
    const euroValue = (parseFloat(rupees) / 90).toFixed(2);
    setEuros(euroValue);
  };

  return (
    <div className="App">
      <h1>React Event Examples</h1>

      <h2>Counter: {count}</h2>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={handleDecrement}>Decrement</button>

      <hr />

      <button onClick={() => sayWelcome("Welcome to React Events!")}>
        Say Welcome
      </button>

      <hr />

      <button onClick={handleClick}>Synthetic Event Click</button>

      <hr />

      <h2>Currency Convertor (INR to Euro)</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Enter amount in ₹"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
        />
        <button type="submit">Convert</button>
      </form>
      {euros && <p>Equivalent in Euros: €{euros}</p>}
    </div>
  );
}

export default App;
