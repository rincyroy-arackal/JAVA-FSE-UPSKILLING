import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    {
      name: "React Cohort - July",
      startDate: "2025-07-01",
      endDate: "2025-07-25",
      status: "ongoing",
    },
    {
      name: "Angular Cohort - June",
      startDate: "2025-06-01",
      endDate: "2025-06-25",
      status: "completed",
    },
  ];

  return (
    <div>
      <h1>Academy Dashboard</h1>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
