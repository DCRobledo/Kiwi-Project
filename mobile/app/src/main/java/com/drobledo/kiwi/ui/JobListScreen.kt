package com.drobledo.kiwi.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drobledo.kiwi.data.local.entity.SavedJob
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun JobListScreen(jobDao: com.drobledo.kiwi.data.local.dao.SavedJobDao) {
    val jobs = remember { mutableStateListOf<SavedJob>() }
    val scope = rememberCoroutineScope()

    // Observe Flow
    LaunchedEffect(true) {
        jobDao.getAll().collectLatest {
            jobs.clear()
            jobs.addAll(it)
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = {
            scope.launch {
                jobDao.insert(SavedJob(title = "Frontend Dev", company = "Kiwi Inc"))
            }
        }) {
            Text("Add Job")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(jobs) { job ->
                Text("🔹 ${job.title} at ${job.company}")
            }
        }
    }
}
