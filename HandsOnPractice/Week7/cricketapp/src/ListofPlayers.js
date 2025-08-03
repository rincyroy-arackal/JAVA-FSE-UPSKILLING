import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Rohit", score: 85 },
    { name: "Kohli", score: 95 },
    { name: "Gill", score: 45 },
    { name: "Surya", score: 67 },
    { name: "Rahul", score: 90 },
    { name: "Hardik", score: 34 },
    { name: "Jadeja", score: 88 },
    { name: "Kuldeep", score: 54 },
    { name: "Bumrah", score: 29 },
    { name: "Shami", score: 70 },
    { name: "Siraj", score: 76 }
  ];

  const below70 = players.filter(p => p.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>

      <h2>Players with score below 70</h2>
      <ul>
        {below70.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
