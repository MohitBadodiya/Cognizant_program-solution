import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 85 },
    { name: 'Rohit Sharma', score: 90 },
    { name: 'KL Rahul', score: 65 },
    { name: 'Shubman Gill', score: 75 },
    { name: 'Hardik Pandya', score: 55 },
    { name: 'Jasprit Bumrah', score: 80 },
    { name: 'Ravindra Jadeja', score: 70 },
    { name: 'Rishabh Pant', score: 60 },
    { name: 'Suryakumar Yadav', score: 95 },
    { name: 'Mohammed Siraj', score: 50 },
    { name: 'Kuldeep Yadav', score: 45 }
  ];

  // Filter players with score < 70
  const filteredPlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players:</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with Score below 70:</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
