package com.ruben.repaso2ev

import android.icu.text.CaseMap.Title
import com.google.gson.annotations.SerializedName


data class MoviesDataResponse(
    @SerializedName("title") val title: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("image") val image: String,
    @SerializedName("synopsis") val synopsis: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("director") val director: String,
    @SerializedName("leadActor") val leadActor: String,
    @SerializedName("writers") val writer: MutableList <String>


)