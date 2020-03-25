package com.dezzapps.quotesapproom.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.quotesapproom.model.Quote
import com.dezzapps.quotesapproom.R
import com.dezzapps.quotesapproom.ui.holder.QuoteHolder
import com.dezzapps.quotesapproom.databinding.ItemQuotesBinding

class CustomAdapter(val quoteList: ArrayList<Quote> = arrayListOf()): RecyclerView.Adapter<QuoteHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteHolder {
        val itemQuotesBinding = ItemQuotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteHolder(itemQuotesBinding)

    }

    override fun getItemCount(): Int {

        return  quoteList.size

    }

    override fun onBindViewHolder(holder: QuoteHolder, position: Int) {

        holder.bind(quoteList[position])
    }


    fun addAll(quote: List<Quote>){
        quoteList.addAll(quote)
        notifyDataSetChanged()

    }
}