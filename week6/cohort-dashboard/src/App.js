import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    {
      name: 'Java Full Stack',
      status: 'ongoing',
      startDate: '2025-07-01',
      endDate: '2025-09-30',
      trainer: 'Mr. Rajeev'
    },
    {
      name: 'Python Data Science',
      status: 'completed',
      startDate: '2025-04-01',
      endDate: '2025-06-30',
      trainer: 'Ms. Swati'
    },
    {
      name: 'Cloud Fundamentals',
      status: 'completed',
      startDate: '2025-01-10',
      endDate: '2025-03-10',
      trainer: 'Mr. Vikram'
    }
  ];

  return (
    <div>
      <h1 style={{ textAlign: 'center' }}>Cohort Dashboard</h1>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
