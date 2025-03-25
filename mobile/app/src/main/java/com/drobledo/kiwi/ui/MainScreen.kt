package com.drobledo.kiwi.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    Text("Hello World!")
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}