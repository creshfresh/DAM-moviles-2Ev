package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.Dao.StudentDao


@Database(entities = [StudentEntity ::class] , version = 1)
abstract class Database : RoomDatabase() {
    abstract fun gestStudentDato() : StudentDao
}