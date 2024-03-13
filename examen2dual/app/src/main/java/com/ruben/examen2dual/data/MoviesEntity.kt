package com.ruben.examen2dual.data

import android.icu.text.CaseMap.Title
import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ruben.examen2dual.Movie


@Entity(tableName = "moviestable")
data class MoviesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name ="image") val image: String,
    @ColumnInfo(name ="director") val director: String,
    @ColumnInfo(name ="duration") val duration: String,
    @ColumnInfo(name ="releaseDate") val releaseDate: String,
    @ColumnInfo(name ="genre") val genre: String,
)

fun Movie.toDataBase () =MoviesEntity(title = title, image = image, director = director, duration = duration, releaseDate = releaseDate, genre = genre )


