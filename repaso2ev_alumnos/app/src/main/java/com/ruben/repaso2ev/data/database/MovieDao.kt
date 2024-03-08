package com.ruben.repaso2ev.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ruben.repaso2ev.data.entities.MoviesEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM moviesTable WHERE title like :name")
    suspend fun getAllMovies(name: String): List<MoviesEntity>

    @Query("SELECT * FROM moviesTable WHERE id LIKE :id ")
    suspend fun getMovie(id: Int): List<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(lista:List<MoviesEntity>)

    @Query("DELETE FROM moviesTable")
    suspend fun deleteAllMovies()

}