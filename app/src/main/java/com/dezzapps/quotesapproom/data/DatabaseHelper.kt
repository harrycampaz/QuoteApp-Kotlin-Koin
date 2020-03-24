package com.dezzapps.quotesapproom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dezzapps.quotesapproom.data.DatabaseHelper.Companion.DATABASE_VERSION
import com.dezzapps.quotesapproom.model.Quote

@Database(entities =  arrayOf(Quote::class), version = DATABASE_VERSION)
abstract class DatabaseHelper: RoomDatabase() {

    abstract fun quotesDao(): QuoteDao



    companion object {
        const val DATABASE_VERSION = 1
        val DATABASE_NAME =  "quotesDB"
        private var mInstance: DatabaseHelper? = null

        fun getInstance(context: Context): DatabaseHelper{
            if(mInstance == null){
                mInstance = Room.databaseBuilder(context, DatabaseHelper::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return mInstance!!
        }


    }
}