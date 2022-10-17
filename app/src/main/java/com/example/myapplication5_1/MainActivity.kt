package com.example.myapplication5_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication5_1.db.MyAdapter
import com.example.myapplication5_1.db.MyDataBase
import com.example.myapplication5_1.db.MyNote
import com.example.myapplication5_1.db.MyNoteDao
import com.example.myapplication5_1.db.MyNoteDao_Impl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val listAdapter=MyAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun onResume() {
        super.onResume()
        val db=Room.databaseBuilder(
            applicationContext,
            MyDataBase::class.java,"notes_database"
        ).build()
        val myNoteDao:MyNoteDao=db.myNoteDao()
        val job:Job=GlobalScope.launch(Dispatchers.IO) {
            val notes=myNoteDao.getAllNotes()
            runOnUiThread{
                listAdapter.updateAdapter(notes)
            }
        }
    }
    fun addNote(view: View){
        val intent= Intent(this,AddNoteActivity::class.java).apply {  }
        startActivity(intent)
    }
    fun init(){
        val rcView:RecyclerView=findViewById(R.id.rcView)
        rcView.layoutManager=LinearLayoutManager(this)
        rcView.adapter=listAdapter
    }

}