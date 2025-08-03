import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders GitHub Repositories heading', () => {
  render(<App />);
  const heading = screen.getByRole('heading', { name: /GitHub Repositories/i });
  expect(heading).toBeInTheDocument();
});
