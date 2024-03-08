package com.example.bd_room_cristinaramos.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bd_room_cristinaramos.data.entities.SuperHeroDetailEntity
import com.example.bd_room_cristinaramos.data.entities.SuperHeroEntity

@Database(entities = [SuperHeroEntity::class, SuperHeroDetailEntity ::class], version = 1)

abstract class SuperHeroDataBase:RoomDatabase() {
    abstract fun getSuperheroes(): SuperHeroDao
    abstract fun getSuperHeroDetail(): SuperHeroDetailDao
}