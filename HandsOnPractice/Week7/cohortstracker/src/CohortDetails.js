import React from 'react';

function CohortDetails(props) {
  const cohort = props.cohort || { code: 'N/A', name: 'N/A', status: 'N/A' };

  return (
    <div>
      <h3>{cohort.code}</h3>
      <p>Name: {cohort.name}</p>
      <p>Status: {cohort.status}</p>
    </div>
  );
}

export default CohortDetails;
