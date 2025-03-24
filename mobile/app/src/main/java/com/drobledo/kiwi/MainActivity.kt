package com.drobledo.kiwi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.drobledo.kiwi.data.local.KiwiDatabase
import com.drobledo.kiwi.ui.JobListScreen
import com.drobledo.kiwi.ui.theme.KiwiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create an in-memory Room DB instance for testing
        val db = Room.inMemoryDatabaseBuilder(
            applicationContext,
            KiwiDatabase::class.java
        ).build()

        val jobDao = db.savedJobDao()

        setContent {
            KiwiTheme {
                JobListScreen(jobDao = jobDao)
            }
        }
    }
}
