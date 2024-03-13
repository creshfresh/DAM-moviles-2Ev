package com.ruben.examen2dual.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll (moviesEntity: List<MoviesEntity>)

    @Query("SELECT * FROM moviestable")
    suspend fun getAll () : List<MoviesEntity>

    @Query ("DELETE FROM moviestable")
    suspend fun deleteAll ()

    @Query ("SELECT * from moviestable WHERE genre like 'Acción'")
    suspend fun  getAcctionMovie(): List <MoviesEntity>

}