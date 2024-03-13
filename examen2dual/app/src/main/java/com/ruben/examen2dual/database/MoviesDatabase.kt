package com.ruben.examen2dual.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ruben.examen2dual.data.MovieDao
import com.ruben.examen2dual.data.MoviesEntity


@Database (entities = [MoviesEntity :: class], version = 1)
abstract class MoviesDatabase: RoomDatabase () {
    abstract fun getMoviesDao() : MovieDao
}