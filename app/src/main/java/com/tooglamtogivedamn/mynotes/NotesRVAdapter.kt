package com.tooglamtogivedamn.mynotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tooglamtogivedamn.mynotes.databinding.ItemNoteBinding

class NotesRVAdapter(private val context: Context, private val listener:INotesRVAdapter):RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    private val allNotes=ArrayList<Note>()
    inner class NoteViewHolder(val bind: ItemNoteBinding):RecyclerView.ViewHolder(bind.root){
//        val textView: TextView = itemView.findViewById<TextView>(R.id.text)
//        val deleteButton: ImageView =itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder=NoteViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        viewHolder.bind.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
       return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       val currentNote = allNotes[position]
        holder.bind.text.text=currentNote.text
    }
    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface INotesRVAdapter{
    fun onItemClicked(note:Note)
}