package com.drobledo.kiwi.ui

import android.R
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.drobledo.kiwi.ui.theme.KiwiPrimary
import com.drobledo.kiwi.ui.theme.KiwiTheme

@Composable
fun HelloScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello from Mobile!", color = KiwiPrimary)
    }
}

@Preview(showBackground = true)
@Composable
fun HelloScreenPreview() {
    KiwiTheme {
        HelloScreen()
    }
}

