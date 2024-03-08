package com.example.consumoapis

import android.media.Image
import com.google.gson.annotations.SerializedName
import okhttp3.internal.platform.Platform


data class VideoGameDataResponse(
    @SerializedName("results") val videoGames: List<VideoGameItemResponse>,
)
data class VideoGameItemResponse(
    @SerializedName("name") val videoGameName: String,
    @SerializedName("released") val releaseDate: String,
    @SerializedName("background_image") val image: String,
    @SerializedName("rating") val rating: Float,
    @SerializedName("platforms") val platforms: List <Platforms>
)

data class Platforms (
    @SerializedName("platform") val platform: ConsolePlatformName
)

data class ConsolePlatformName (
    @SerializedName("name") val platformName: String
)

