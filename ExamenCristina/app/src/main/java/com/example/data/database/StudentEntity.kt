package com.example.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.examencristina.Student


@Entity (tableName = "student_table")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "grade") val grade: Double,
    @ColumnInfo(name = "name") val name: String

)

fun Student.toDataBase () = StudentEntity(name = name, grade = grade)
