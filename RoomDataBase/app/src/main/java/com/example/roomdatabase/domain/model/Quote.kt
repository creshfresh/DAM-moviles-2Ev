package com.example.roomdatabase.domain.model

import com.example.roomdatabase.data.entities.QuoteEntity
import com.example.roomdatabase.data.model.QuoteModel

data class Quote (val quote:String, val author:String)
// Los mapper se declaran en la clase final donde queremos heredar
fun QuoteModel.toDomain() = Quote(quote, author)    //Quote hereda los atributos quote y author de QuoteModel
fun QuoteEntity.toDomain() = Quote(quote, author)