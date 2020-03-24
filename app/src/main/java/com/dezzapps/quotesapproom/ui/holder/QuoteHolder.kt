package com.dezzapps.quotesapproom.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.quotesapproom.model.Quote
import kotlinx.android.synthetic.main.item_quotes.view.*

class QuoteHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(quote: Quote){

        with(itemView){
            tv_item.text = quote.text
        }
    }

}
