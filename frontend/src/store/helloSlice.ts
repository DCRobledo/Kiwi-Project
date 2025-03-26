import {createAsyncThunk, createSlice, PayloadAction} from "@reduxjs/toolkit";
import api from "../services/api";

interface HelloState {
    message: string;
    status: 'idle' | 'loading' | 'succeeded' | 'failed';
}

export const fetchHelloMessage = createAsyncThunk<string, number>(
    'hello/fetchMessage',
    async (id, { rejectWithValue }) => {
        try {
            const response = await api.get(`/hello/${id}`);
            return response.data.message;  
        } catch (error) {
            return rejectWithValue(error); 
        }
    }
);


const helloSlice = createSlice({
    name: 'hello',
    initialState: { message: '', status: 'idle' } as HelloState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchHelloMessage.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(fetchHelloMessage.fulfilled, (state, action: PayloadAction<string>) => {
                state.status = 'succeeded';
                state.message = action.payload;
            })
            .addCase(fetchHelloMessage.rejected, (state) => {
                state.status = 'failed';
            });
    },
});

export default helloSlice.reducer;
