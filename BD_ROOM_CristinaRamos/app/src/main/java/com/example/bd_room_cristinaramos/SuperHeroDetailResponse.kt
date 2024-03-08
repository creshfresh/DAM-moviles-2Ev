package com.example.bd_room_cristinaramos

import com.google.gson.annotations.SerializedName

data class SuperHeroDetailResponse (
    @SerializedName("results") val superheroes: List<SuperHeroDetailIdResponse>
)

data class SuperHeroDetailIdResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("appearance") val appearance: Appearance

)data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)
data class SuperheroImageDetailResponse(@SerializedName("url") val url:String)

data class Biography(
    @SerializedName("full-name") val fullName:String,
    @SerializedName("publisher") val publisher:String,
    @SerializedName("aliases") val aliases: List <String>
)
data class Appearance (
    @SerializedName("eye-color") val eyeColor: String,
    @SerializedName("race") val race: String,

    )