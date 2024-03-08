package com.example.bd_room_cristinaramos.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bd_room_cristinaramos.data.entities.SuperHeroDetailEntity

@Dao
interface SuperHeroDetailDao {
    @Query("SELECT * FROM superhero_detail_table WHERE id like :query")
    suspend fun getDetailSuperHeros(query: Int): SuperHeroDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSuperheros(lista:List<SuperHeroDetailEntity>)

    @Query("DELETE FROM superhero_detail_table")
    suspend fun deleteAllHeroes()
}