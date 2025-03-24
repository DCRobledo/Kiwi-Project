import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import App from '../App';
import { Provider } from 'react-redux';
import { store } from '../app/store'; 

test('renders counter with initial value', () => {
    render(
        <Provider store={store}>
            <App />
        </Provider>
    );

    expect(screen.getByText(/count: 0/i)).toBeInTheDocument();
});
