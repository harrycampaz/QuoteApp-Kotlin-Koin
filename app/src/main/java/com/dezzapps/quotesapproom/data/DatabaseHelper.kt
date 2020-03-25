package com.dezzapps.quotesapproom.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dezzapps.quotesapproom.data.DatabaseHelper.Companion.DATABASE_VERSION
import com.dezzapps.quotesapproom.model.Quote

@Database(entities = [Quote::class], version = DATABASE_VERSION)
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
                    .addCallback(callback)
                    .build()
            }

            return mInstance!!
        }

        private val callback: Callback = object : Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                Log.d("DB Creada: ", db.path)
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                Log.d("DB Open: ", db.path)
            }

        }

    }

}