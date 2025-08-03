import React from 'react';
import { render, screen } from '@testing-library/react';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('CohortDetails component', () => {
  test('renders without crashing', () => {
    render(<CohortDetails />);
    expect(screen.getByRole('heading')).toHaveTextContent('N/A');
    expect(screen.getByText('Name: N/A')).toBeInTheDocument();
    expect(screen.getByText('Status: N/A')).toBeInTheDocument();
  });

  test('displays cohort data passed via props', () => {
    const cohort = CohortData[0];
    render(<CohortDetails cohort={cohort} />);
    expect(screen.getByRole('heading')).toHaveTextContent(cohort.code);
    expect(screen.getByText(`Name: ${cohort.name}`)).toBeInTheDocument();
    expect(screen.getByText(`Status: ${cohort.status}`)).toBeInTheDocument();
  });

  test('matches snapshot', () => {
    const cohort = CohortData[0];
    const { asFragment } = render(<CohortDetails cohort={cohort} />);
    expect(asFragment()).toMatchSnapshot();
  });
});
