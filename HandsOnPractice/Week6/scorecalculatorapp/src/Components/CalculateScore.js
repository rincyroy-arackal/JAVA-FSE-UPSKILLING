import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
  const name = "John Doe";
  const school = "Sunshine High School";
  const total = 480;
  const goal = 600;
  const average = (total / goal) * 100;

  return (
    <div className="score-container">
      <h1>Student Score Report</h1>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total:</strong> {total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}%</p>
    </div>
  );
}

export default CalculateScore;