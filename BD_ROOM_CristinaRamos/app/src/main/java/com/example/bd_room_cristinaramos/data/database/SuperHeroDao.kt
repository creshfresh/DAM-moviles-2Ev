package com.example.bd_room_cristinaramos.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bd_room_cristinaramos.data.entities.SuperHeroEntity
@Dao
interface SuperHeroDao {


    @Query("SELECT * FROM superherotable WHERE name like :name")
    suspend fun getAllSuperHeros(name: String): List<SuperHeroEntity>

    @Query("SELECT * FROM superherotable WHERE id LIKE :id ")
    suspend fun getSuperHero(id: Int): List<SuperHeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSuperheros(lista:List<SuperHeroEntity>)

    @Query("DELETE FROM superherotable")
    suspend fun deleteAllHeroes()

}