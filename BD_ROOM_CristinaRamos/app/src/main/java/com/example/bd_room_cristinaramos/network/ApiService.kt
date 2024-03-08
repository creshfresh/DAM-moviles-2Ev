package com.example.bd_room_cristinaramos.network

import com.example.bd_room_cristinaramos.SuperHeroDataResponse
import com.example.bd_room_cristinaramos.SuperHeroDetailResponse
import com.example.bd_room_cristinaramos.SuperheroItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/3749436348611899/search/sp")
    suspend fun getSuperheroes(): Response<SuperHeroDataResponse>
    @GET("/api/3749436348611899/search/sp")
    suspend fun getSuperheroDetail(): Response<SuperHeroDetailResponse>

}
