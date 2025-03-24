import { useDispatch, useSelector } from 'react-redux';
import { increment } from './features/counter/counterSlice';
import { RootState } from './app/store';

function App() {
    const count = useSelector((state: RootState) => state.counter.value);
    const dispatch = useDispatch();

    return (
        <div className="p-6">
            <p className="text-xl">Count: {count}</p>
            <button
                onClick={() => dispatch(increment())}
                className="mt-4 px-4 py-2 bg-blue-500 text-white rounded"
            >
                Increment
            </button>
        </div>
    );
}

export default App;