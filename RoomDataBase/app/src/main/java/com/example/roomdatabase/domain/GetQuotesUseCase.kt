package com.example.roomdatabase.domain

import com.example.roomdatabase.data.QuoteRepository
import com.example.roomdatabase.data.entities.toDatabase
import com.example.roomdatabase.data.model.QuoteModel
import com.example.roomdatabase.domain.model.Quote
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository) {
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes

        }else{ //Si falla la llamada a la API, se cargan las citas desde la base de datos
            repository.getAllQuotesFromDatabase()
        }
    }

}
