package com.dezzapps.quotesapproom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter: CustomAdapter by lazy {
        CustomAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_quote.layoutManager = LinearLayoutManager(this)
        rv_quote.adapter = adapter

        adapter.add(Quote(1, "Here you are 1"))
        adapter.add(Quote(2, "Here you are 2"))
        adapter.add(Quote(3, "Here you are 3"))

        tv_count.text = "Count 2"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add_action){

        }

        return super.onOptionsItemSelected(item)
    }
}
