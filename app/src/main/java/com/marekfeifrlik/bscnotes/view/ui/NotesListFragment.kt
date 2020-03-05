package com.marekfeifrlik.bscnotes.view.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.marekfeifrlik.bscnotes.R
import com.marekfeifrlik.bscnotes.utils.hide
import com.marekfeifrlik.bscnotes.utils.show
import com.marekfeifrlik.bscnotes.view.adapter.NoteClickListener
import com.marekfeifrlik.bscnotes.view.adapter.NotesAdapter
import com.marekfeifrlik.bscnotes.viewmodel.NotesSharedViewModel
import com.marekfeifrlik.common.model.ListenerType
import kotlinx.android.synthetic.main.fragment_notes_list.*

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
class NotesListFragment : BaseFragment() {

    private lateinit var viewModel: NotesSharedViewModel
    private lateinit var notesAdapter: NotesAdapter

    private val noteClickListener = object : NoteClickListener {
        override fun onNoteClicked(clicked: ListenerType) {
            when (clicked) {
                is ListenerType.DetailClickListener -> showNoteDetails(clicked.note.id)
                is ListenerType.DeleteClickListener -> deleteNote(clicked.note.id)
            }
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_notes_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(NotesSharedViewModel::class.java)
        viewModel.getNotes()
        loadData()
    }

    override fun initViews() {
        showEmptyView()
        val supportActionBar = (activity as ContentActivity).supportActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        viewModel.statusMsg.observe(this, Observer { status ->
            status?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        })
        swipeContainer.setOnRefreshListener {
            showRefreshDialog()
            loadData()
        }
        addNoteFab.setOnClickListener {
            showNoteDetails(0)
        }
        notesAdapter = NotesAdapter(noteClickListener)
        rvNotes.adapter = notesAdapter
    }

    private fun loadData() {
        try {
            viewModel.notesListLiveData.observe(this, Observer {
                notesAdapter.updateList(it)
                hideEmptyView()
                hideRefreshDialog()
            })
        } catch (e: Exception) {
            showEmptyView()
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun showNoteDetails(noteId: Int) {
        navControllerMain()?.navigate(
            NotesListFragmentDirections.actionToNoteDetailFragmentFromNotesListFragment(noteId)
        )
    }

    private fun deleteNote(noteId: Int) {
        viewModel.deleteNote(noteId)
    }

    private fun showEmptyView() {
        emptyPlaceholder.show()
        rvNotes.hide()
        hideRefreshDialog()
    }

    private fun hideEmptyView() {
        emptyPlaceholder.hide()
        rvNotes.show()
        hideRefreshDialog()
    }

    private fun showRefreshDialog() {
        swipeContainer.isRefreshing = true
    }

    private fun hideRefreshDialog() {
        swipeContainer.isRefreshing = false
    }

}