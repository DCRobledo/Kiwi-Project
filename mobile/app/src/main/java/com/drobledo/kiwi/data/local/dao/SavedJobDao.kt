package com.drobledo.kiwi.data.local.dao

import androidx.room.*
import com.drobledo.kiwi.data.local.entity.SavedJob
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedJobDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(job: SavedJob)

    @Query("SELECT * FROM saved_jobs ORDER BY dateSaved DESC")
    fun getAll(): Flow<List<SavedJob>>

    @Delete
    suspend fun delete(job: SavedJob)
}
