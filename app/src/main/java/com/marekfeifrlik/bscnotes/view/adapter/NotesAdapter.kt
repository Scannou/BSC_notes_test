package com.marekfeifrlik.bscnotes.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.marekfeifrlik.bscnotes.R
import com.marekfeifrlik.common.model.ListenerType
import com.marekfeifrlik.common.model.Note
import kotlinx.android.synthetic.main.list_item_note.view.*

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
class NotesAdapter(val listener: NoteClickListener) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private var notesList: List<Note> = ArrayList()

    class NotesViewHolder(itemView: View, listener: NoteClickListener) : RecyclerView.ViewHolder(itemView) {

        private val tvNoteId: TextView = itemView.noteId
        private val tvNoteTitle: TextView = itemView.noteTitle
        private val btnDelete: MaterialButton = itemView.deleteButton

        fun bindItems(note: Note, listener: NoteClickListener) {
            with(note) {
                tvNoteId.text = id.toString()
                tvNoteTitle.text = title
                itemView.setOnClickListener {
                    listener.onNoteClicked(ListenerType.DetailClickListener(note))
                }
                btnDelete.setOnClickListener {
                    listener.onNoteClicked(ListenerType.DeleteClickListener(note))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_note, parent, false)
        return NotesViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bindItems(notesList[position], listener)
    }

    fun updateList(items: List<Note>) {
        notesList = items
        notifyDataSetChanged()
    }

}

