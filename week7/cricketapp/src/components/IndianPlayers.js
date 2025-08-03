import React from 'react';

const IndianPlayers = () => {
  const T20players = ['Virat Kohli', 'Rohit Sharma', 'Suryakumar Yadav', 'Rishabh Pant'];
  const RanjiTrophyPlayers = ['Ajinkya Rahane', 'Cheteshwar Pujara', 'Mayank Agarwal', 'Prithvi Shaw'];

  // Merge Arrays
  const allPlayers = [...T20players, ...RanjiTrophyPlayers];

  // Destructuring Odd and Even Team
  const oddTeam = allPlayers.filter((_, index) => index % 2 === 0);
  const evenTeam = allPlayers.filter((_, index) => index % 2 !== 0);

  return (
    <div>
      <h2>Odd Team Players:</h2>
      <ul>
        {oddTeam.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h2>Even Team Players:</h2>
      <ul>
        {evenTeam.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
