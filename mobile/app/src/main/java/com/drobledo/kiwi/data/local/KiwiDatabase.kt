package com.drobledo.kiwi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.drobledo.kiwi.data.local.dao.SavedJobDao
import com.drobledo.kiwi.data.local.entity.SavedJob

@Database(entities = [SavedJob::class], version = 1)
abstract class KiwiDatabase : RoomDatabase() {
    abstract fun savedJobDao(): SavedJobDao
}
