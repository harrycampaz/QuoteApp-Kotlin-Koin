package com.dezzapps.quotesapproom.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dezzapps.quotesapproom.model.Quote
import com.dezzapps.quotesapproom.R
import com.dezzapps.quotesapproom.data.DatabaseHelper
import com.dezzapps.quotesapproom.data.QuoteDao
import com.dezzapps.quotesapproom.ui.adapter.CustomAdapter
import com.dezzapps.quotesapproom.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private val adapter: CustomAdapter by lazy {
        CustomAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_quote.layoutManager = LinearLayoutManager(this)
        rv_quote.adapter = adapter

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.getAllQuotes().observe(this, Observer {

            if(it.isEmpty()){
                tv_count.text = getString(R.string.no_data)

                return@Observer
            }
           adapter.addAll(it)

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add_action){

            mainActivityViewModel.saveQuotes(Quote(text = "Mi primera frase"))

        }

        return super.onOptionsItemSelected(item)
    }
}
