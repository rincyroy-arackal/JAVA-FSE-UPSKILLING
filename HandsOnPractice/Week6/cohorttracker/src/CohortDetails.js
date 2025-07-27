import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const isOngoing = cohort.status.toLowerCase() === "ongoing";

  return (
    <div className={styles.box}>
      <h3 style={{ color: isOngoing ? "green" : "blue" }}>
        {cohort.name}
      </h3>
      <dl>
        <dt>Start Date:</dt>
        <dd>{cohort.startDate}</dd>

        <dt>End Date:</dt>
        <dd>{cohort.endDate}</dd>

        <dt>Status:</dt>
        <dd>{cohort.status}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
