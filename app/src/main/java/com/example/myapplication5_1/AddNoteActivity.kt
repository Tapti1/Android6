package com.example.myapplication5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.myapplication5_1.db.DbHandler
import com.example.myapplication5_1.db.MyDataBase
import com.example.myapplication5_1.db.MyNote
import com.example.myapplication5_1.db.MyNoteDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {
    //var note_id=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        //val i=intent
        //note_id=i.getIntExtra("note_id",0)
        //if(note_id!=0){
            //val dao=DbHandler(applicationContext).getDataBase().myNoteDao()
        //}
    }
    fun saveNote(view: View){
        val dbh=DbHandler(applicationContext)
        val db=dbh.getDataBase()

        val title:EditText=findViewById(R.id.edNoteTitle)
        val content:EditText=findViewById(R.id.edNoteContent)

        val myNote= MyNote(0,title.text.toString(),content.text.toString(),0)
        val myNotesDao: MyNoteDao =db.myNoteDao()

        val job: Job = GlobalScope.launch(Dispatchers.IO) {
            myNotesDao.insertMyNote(myNote)
            runOnUiThread{
                finish()
            }
        }
    }

}