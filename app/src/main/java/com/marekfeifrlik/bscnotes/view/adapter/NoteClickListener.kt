package com.marekfeifrlik.bscnotes.view.adapter

import com.marekfeifrlik.common.model.ListenerType

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
interface NoteClickListener {
    fun onNoteClicked(clicked: ListenerType)
}
