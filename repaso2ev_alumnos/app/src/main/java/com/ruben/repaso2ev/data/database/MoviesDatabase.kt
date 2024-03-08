package com.ruben.repaso2ev.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ruben.repaso2ev.data.entities.MoviesEntity


@Database(entities = [MoviesEntity::class], version = 1)

abstract class MoviesDatabase: RoomDatabase() {
    abstract fun gestMovies(): MovieDao
}