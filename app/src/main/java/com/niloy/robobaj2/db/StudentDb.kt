package com.niloy.robobaj2.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDb : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}
