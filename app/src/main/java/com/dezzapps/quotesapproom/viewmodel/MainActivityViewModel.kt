package com.dezzapps.quotesapproom.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dezzapps.quotesapproom.data.QuoteRepository
import com.dezzapps.quotesapproom.model.Quote

class MainActivityViewModel(application: Application): AndroidViewModel(application) {

    private var quoteRepository: QuoteRepository = QuoteRepository(application)

    fun getAllQuotes(): LiveData<List<Quote>> = quoteRepository.getLiveData()

    fun saveQuotes(quote: Quote){
        Log.d("MainActivityViewModel: ", quote.text )
        quoteRepository.addQuote(quote)
    }
}