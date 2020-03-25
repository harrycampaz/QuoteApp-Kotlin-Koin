package com.dezzapps.quotesapproom.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dezzapps.quotesapproom.model.Quote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class QuoteRepository(application: Application): CoroutineScope {

    var quoteDao: QuoteDao

    init {
        val db = DatabaseHelper.getInstance(application)
        quoteDao = db.quotesDao()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    fun getLiveData(): LiveData<List<Quote>> = quoteDao.getAll()

    fun addQuote(quote: Quote){
        launch { setQuoteBg(quote) }
    }

    private suspend fun setQuoteBg(quote: Quote){
        withContext(Dispatchers.IO){
            quoteDao.insert(quote)
        }
    }
}