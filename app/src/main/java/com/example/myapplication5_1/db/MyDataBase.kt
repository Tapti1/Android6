package com.example.myapplication5_1.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyNote::class], version = 1)
abstract class MyDataBase:RoomDatabase() {
    abstract fun myNoteDao():MyNoteDao
}