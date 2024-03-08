package com.example.bd_room_cristinaramos.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bd_room_cristinaramos.SuperHeroDetailIdResponse

@Entity(tableName = "superhero_detail_table")
data class SuperHeroDetailEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int=0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "fullname") val fullname: String,
    @ColumnInfo(name = "publisher") val publisher: String,
    @ColumnInfo(name = "intelligence") val intelligence: String,
    @ColumnInfo(name = "strength") val strength: String,
    @ColumnInfo(name = "speed") val speed: String,
    @ColumnInfo(name = "durability") val durability: String,
    @ColumnInfo(name = "power") val power: String,
    @ColumnInfo(name = "combat") val combat: String,
    @ColumnInfo(name = "image") val image : String,
    )

fun SuperHeroDetailIdResponse.toDatabase() = SuperHeroDetailEntity(
    name = name,
    intelligence = powerstats.intelligence,
    combat = powerstats.combat,
    durability = powerstats.durability,
    fullname = biography.fullName,
    image = image.url,
    power = powerstats.power,
    publisher = biography.publisher,
    speed = powerstats.speed,
    strength = powerstats.strength)
