package com.example.roomdatabase.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.model.QuoteModel
import com.example.roomdatabase.domain.GetQuotesUseCase
import com.example.roomdatabase.domain.GetRandomQuoteUseCase
import com.example.roomdatabase.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase

) : ViewModel() {
    val quoteModel = MutableLiveData<Quote?>()
    val isLoading = MutableLiveData<Boolean>()

    fun randomQuote() {
        viewModelScope.launch {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }}
    fun onCreate () {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getQuotesUseCase()
            val quote = getRandomQuoteUseCase()
            if (!result.isNullOrEmpty()){
              //  quoteModel.postValue(result[0])
                quoteModel.postValue(quote)
                isLoading.postValue(false)
            }
        }
    }


}