package com.dezzapps.quotesapproom

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_quotes.view.*

class QuoteHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(){
        itemView.tv_item.text = "Frase"
    }

}