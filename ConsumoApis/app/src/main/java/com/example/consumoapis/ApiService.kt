package com.example.consumoapis
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

interface ApiService {
    @GET("api/games?key=452a0f38c4fd42c59429a5e5f88cb7ae")
    suspend fun getVideoGames( @Query("search") search: String): Response<VideoGameDataResponse>

}