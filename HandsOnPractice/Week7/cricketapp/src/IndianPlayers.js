import React from 'react';

const IndianPlayers = () => {
  const T20players = ["Rohit", "Kohli", "Hardik", "Pant"];
  const RanjiTrophy = ["Jaiswal", "Sarfaraz", "Shubman", "Prithvi"];

  // Merge
  const allPlayers = [...T20players, ...RanjiTrophy];

  // Destructure
  const oddTeam = allPlayers.filter((_, index) => index % 2 !== 0);
  const evenTeam = allPlayers.filter((_, index) => index % 2 === 0);

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        {oddTeam.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenTeam.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
