package com.dezzapps.quotesapproom.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dezzapps.quotesapproom.model.Quote

@Dao
interface QuoteDao {

    @Insert
    fun insert(quote: Quote)

    @Query("select * from quotes")
    fun getAll(): List<Quote>
}