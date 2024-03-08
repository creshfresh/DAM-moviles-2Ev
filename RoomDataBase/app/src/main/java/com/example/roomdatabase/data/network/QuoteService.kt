package com.example.roomdatabase.data.network

import com.example.roomdatabase.core.RetrofitHelper
import com.example.roomdatabase.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api: QuoteApiClient) {
    suspend fun getQuotes() : List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}