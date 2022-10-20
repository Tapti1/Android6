package com.example.myapplication5_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.myapplication5_1.db.DbHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class ShowNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_note)

        val i=intent
        val note_id=i.getIntExtra("note_id",0)

        if(note_id!=0){
            val noteDao=DbHandler(applicationContext).getDataBase().myNoteDao()

            val job: Job =GlobalScope.launch(Dispatchers.IO) {
                val note=noteDao.getNote(note_id)

                runOnUiThread{
                    val tvShowNoteTitle: TextView =findViewById(R.id.tvShowNoteTitle)
                    tvShowNoteTitle.text=note.title

                    val tvShowNoteContext:TextView=findViewById(R.id.tvShowNoteContent)
                    tvShowNoteContext.text=note.content

                    val tvShowNoteStatus:TextView=findViewById(R.id.tvShowNoteStatus)
                    tvShowNoteStatus.text=note.status.toString()
                }
            }
        }
        else{
            val job: Job =GlobalScope.launch(Dispatchers.IO) {
                runOnUiThread{
                    val tvShowNoteTitle: TextView =findViewById(R.id.tvShowNoteTitle)
                    tvShowNoteTitle.text="Запись не найдёна"
                }
            }
        }
        fun updateNote(view:View){
            if(note_id!=0){
                val intent= Intent(this,AddNoteActivity::class.java).apply{
                    //putExtra("note_id",note_id)
                }
                startActivity(intent)
            }
        }
    }
}