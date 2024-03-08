package com.example.data.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.StudentEntity
import com.example.examencristina.Student

@Dao

interface  StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll (students : List<StudentEntity>)

    @Query("SELECT * FROM student_table")
    suspend fun getAll() : List<StudentEntity>

    @Query("DELETE  FROM student_table")
    suspend fun deleteAll()


    @Query ("SELECT * FROM student_table WHERE grade >= 5")
    suspend fun getselectPass() :List<StudentEntity>

    @Query ("SELECT * FROM student_table WHERE grade <= 5")
    suspend fun getselectFail() :List<StudentEntity>
}