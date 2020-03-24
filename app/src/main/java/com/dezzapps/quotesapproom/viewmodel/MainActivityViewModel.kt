package com.dezzapps.quotesapproom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dezzapps.quotesapproom.model.Quote

class MainActivityViewModel: ViewModel() {

    private val data = MutableLiveData<List<Quote>>()

    fun getAllQuotes(): LiveData<List<Quote>> = data

    fun loadAllData(){

    }

    fun saveQuotes(quote: Quote){

    }
}