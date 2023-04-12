import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/infos/i);
  expect(linkElement).toBeInTheDocument();
  const linkElement2 = screen.getByText(/reunions/i);
  expect(linkElement2).toBeInTheDocument();
});
