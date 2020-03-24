package com.dezzapps.quotesapproom.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.quotesapproom.model.Quote
import com.dezzapps.quotesapproom.R
import com.dezzapps.quotesapproom.ui.holder.QuoteHolder

class CustomAdapter(val quoteList: ArrayList<Quote> = arrayListOf()): RecyclerView.Adapter<QuoteHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_quotes, parent, false)

        return QuoteHolder(view)

    }

    override fun getItemCount(): Int {

        return  quoteList.size

    }

    override fun onBindViewHolder(holder: QuoteHolder, position: Int) {

        holder.bind(quoteList[position])
    }

    fun add(quote: Quote){
        quoteList.add(quote)
        notifyDataSetChanged()

    }

    fun addAll(quote: List<Quote>){
        quoteList.addAll(quote)
        notifyDataSetChanged()

    }
}