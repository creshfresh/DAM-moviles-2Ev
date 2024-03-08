package com.example.bd_room_cristinaramos.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bd_room_cristinaramos.SuperheroImageResponse
import com.example.bd_room_cristinaramos.SuperheroItemResponse

@Entity(tableName = "superherotable")
data class SuperHeroEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
)
fun SuperheroItemResponse.toDatabase() = SuperHeroEntity(name =  name, image = superheroImage.url)