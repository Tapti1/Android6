package com.example.myapplication5_1.db

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.myapplication5_1.R
import org.w3c.dom.Text

class MyAdapter(notes:ArrayList<MyNote>):RecyclerView.Adapter<MyAdapter.MyHolder> (){
    var listArray=notes

    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val noteTitle:TextView=itemView.findViewById(R.id.noteListTitle)
        fun setData(note: MyNote){
            noteTitle.text=note.title

            if(note.status==1){
                itemView.setBackgroundColor(Color.YELLOW)
            }
        }
    }
    fun updateAdapter(newList: List<MyNote>){
        listArray.clear()
        listArray.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater=LayoutInflater.from(parent.context)
        return MyHolder(inflater.inflate(R.layout.rc_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.setData(listArray.get(position))
    }

    override fun getItemCount(): Int {
        return listArray.size
    }
}