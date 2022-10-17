package com.example.myapplication5_1.db

import androidx.core.location.LocationRequestCompat.Quality
import androidx.room.*
@Dao
interface MyNoteDao {
    @Insert
    fun insertMyNote(note:MyNote)
    @Query("SELECT * FROM notes")
    fun getAllNotes():List<MyNote>
    @Update
    fun uptadeNote(note:MyNote)
    @Delete
    fun delete(note: MyNote)
    @Query("SELECT * FROM notes WHERE id=:note_id")
    fun getNote(note_id:Int):MyNote
}