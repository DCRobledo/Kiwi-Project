package com.drobledo.kiwi.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_jobs")
data class SavedJob(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val company: String,
    val dateSaved: Long = System.currentTimeMillis()
)
