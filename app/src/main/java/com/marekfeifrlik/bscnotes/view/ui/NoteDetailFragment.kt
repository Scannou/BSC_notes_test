package com.marekfeifrlik.bscnotes.view.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.marekfeifrlik.bscnotes.R
import com.marekfeifrlik.bscnotes.viewmodel.NotesSharedViewModel
import com.marekfeifrlik.common.model.Note
import kotlinx.android.synthetic.main.fragment_note_detail.*

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
class NoteDetailFragment : BaseFragment() {

    private lateinit var viewModel: NotesSharedViewModel
    private var noteId: Int = 0

    override fun getLayoutResId(): Int {
        return R.layout.fragment_note_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getInt("extra.noteId")?.let {
            noteId = it
        }
        viewModel = ViewModelProviders.of(activity!!).get(NotesSharedViewModel::class.java)
    }

    override fun initViews() {
        if (noteId != 0) {
            saveButton.setText(R.string.update_note)
            viewModel.getNote(noteId)
            loadData()
        } else saveButton.setText(R.string.save_note)

        viewModel.statusMsg.observe(this, Observer { status ->
            status?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        })

        saveButton.setOnClickListener {
            saveNote(
                Note(
                    if (idInput.text!!.isNotEmpty()) {
                        idInput.text.toString().toInt()
                    } else {
                        Toast.makeText(context, "ID required", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    },
                    if (titleInput.text!!.isNotEmpty()) {
                        titleInput.text.toString()
                    } else {
                        Toast.makeText(context, "Title required", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                )
            )
        }
    }

    private fun loadData() {
        viewModel.noteLiveData.observe(this, Observer {
            idInput.setText(it.id.toString())
            titleInput.setText(it.title)
        })
    }

    private fun saveNote(note: Note) {
        if (noteId != 0) {
            viewModel.updateNote(note)
        } else viewModel.saveNote(note)
        activity?.onBackPressed()
    }

}