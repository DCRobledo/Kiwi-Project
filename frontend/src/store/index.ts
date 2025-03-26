import { configureStore } from '@reduxjs/toolkit';
import helloReducer from './helloSlice';

const store = configureStore({
    reducer: {
        hello: helloReducer,
    },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export default store;
