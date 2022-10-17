package com.example.myapplication5_1.db

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "notes")
data class MyNote (
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var content:String,
    var status:Int
)
