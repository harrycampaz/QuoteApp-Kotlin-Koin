package com.dezzapps.quotesapproom.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dezzapps.quotesapproom.databinding.ItemQuotesBinding
import com.dezzapps.quotesapproom.model.Quote
import kotlinx.android.synthetic.main.item_quotes.view.*

class QuoteHolder(private val itemBinding: ItemQuotesBinding): RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(quote: Quote){

        with(itemBinding){
            tvItem.text = quote.text
        }
    }

}
