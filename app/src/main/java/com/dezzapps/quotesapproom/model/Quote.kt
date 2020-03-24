package com.dezzapps.quotesapproom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class Quote (

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var text: String)