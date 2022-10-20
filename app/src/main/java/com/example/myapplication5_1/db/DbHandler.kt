package com.example.myapplication5_1.db

import android.content.Context
import androidx.room.Room

class DbHandler(context: Context) {
    val db= Room.databaseBuilder(
        context,
        MyDataBase::class.java,"notes_database"
    ).build()
    fun getDataBase():MyDataBase{
        return db
    }
}