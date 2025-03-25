package com.drobledo.kiwi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drobledo.kiwi.network.Job
import com.drobledo.kiwi.network.RetrofitClient
import retrofit2.HttpException

// MainActivity to manage state and fetch data from backend
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobListScreen()
        }
    }
}

// Fetch jobs and update state
@Composable
fun JobListScreen() {
    // Declare state variables with remember to retain the state across recompositions
    val jobList = remember { mutableStateOf<List<Job>>(emptyList()) }
    val isLoading = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf<String?>(null) }

    // Function to fetch jobs from backend
    suspend fun fetchJobs() {
        isLoading.value = true
        errorMessage.value = null

        try {
            val jobs = RetrofitClient.apiService.getJobs()
            jobList.value = jobs // Update the state with the result
            isLoading.value = false
        } catch (e: HttpException) {
            // Handle error case
            isLoading.value = false
            errorMessage.value = "Failed to load jobs"
            Log.e("JobList", "Error: ${e.message}")
        } catch (e: Exception) {
            isLoading.value = false
            errorMessage.value = "Unknown error occurred"
            Log.e("JobList", "Error: ${e.message}")
        }
    }

    // Automatically load jobs when the screen is composed
    LaunchedEffect(true) {
        fetchJobs()
    }

    Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
        Text(text = "Job List")

        if (isLoading.value) {
            CircularProgressIndicator(modifier = androidx.compose.ui.Modifier.padding(top = 16.dp))
        }

        errorMessage.value?.let {
            Text(text = it, color = androidx.compose.ui.graphics.Color.Red)
        }

        LazyColumn(modifier = androidx.compose.ui.Modifier.padding(top = 16.dp)) {
            items(jobList.value) { job ->
                JobItem(job)
            }
        }
    }
}

@Composable
fun JobItem(job: Job) {
    Column(modifier = androidx.compose.ui.Modifier.padding(8.dp)) {
        Text(text = job.title)
        Text(text = "Company: ${job.company}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JobListScreen()
}
