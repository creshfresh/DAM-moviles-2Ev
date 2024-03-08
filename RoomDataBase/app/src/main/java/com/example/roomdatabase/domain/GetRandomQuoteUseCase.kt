package com.example.roomdatabase.domain

import com.example.roomdatabase.data.QuoteRepository
import com.example.roomdatabase.data.model.QuoteModel
import com.example.roomdatabase.data.model.QuoteProvider
import com.example.roomdatabase.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository,
    private val quoteProvider: QuoteProvider
) {
    //Ahora no necesita una corrutina porque lo tenemos almacenado en QuoteProvider
    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDatabase()

        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}