package com.drobledo.kiwi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.drobledo.kiwi.data.local.KiwiDatabase
import com.drobledo.kiwi.data.local.entity.SavedJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SavedJobDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var db: KiwiDatabase

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            KiwiDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun insertAndRetrieveJob() = runBlocking {
        val job = SavedJob(title = "Test Job", company = "Kiwi")
        db.savedJobDao().insert(job)

        val result = db.savedJobDao().getAll().first()

        Assert.assertTrue(result.any { it.title == "Test Job" })
    }
}