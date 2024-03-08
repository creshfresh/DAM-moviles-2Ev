package com.example.roomdatabase.data

import com.example.roomdatabase.data.database.QuoteDao
import com.example.roomdatabase.data.entities.QuoteEntity
import com.example.roomdatabase.data.model.QuoteModel
import com.example.roomdatabase.data.model.QuoteProvider
import com.example.roomdatabase.data.network.QuoteService
import com.example.roomdatabase.domain.model.Quote
import com.example.roomdatabase.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: QuoteDao

) {
    //Devuelve el listado de citas de la api

    suspend fun getAllQuotesFromApi () : List<Quote>{
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }

    }
    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }
    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }


}
