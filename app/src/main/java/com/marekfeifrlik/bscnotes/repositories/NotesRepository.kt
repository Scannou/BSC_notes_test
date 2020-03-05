package com.marekfeifrlik.bscnotes.repositories

import com.marekfeifrlik.api.NotesApi
import com.marekfeifrlik.common.model.Note

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
class NotesRepository(private val api: NotesApi) : BaseRepository() {

    suspend fun getNotes(): MutableList<Note>? {
        return safeApiCall(
            call = { api.getNotesList() },
            error = "Error getting notes"
        )?.toMutableList()
    }

    suspend fun getNote(noteId: Int): Note? {
        return safeApiCall(
            call = { api.getNote(noteId) },
            error = "Error getting note"
        )
    }

    suspend fun saveNote(note: Note): Note? {
        return safeApiCall(
            call = { api.postNote(note) },
            error = "Error saving note"
        )
    }

    suspend fun updateNote(note: Note): Note? {
        return safeApiCall(
            call = { api.updateNote(note.id, note) },
            error = "Error updating note"
        )
    }

    suspend fun deleteNote(noteId: Int): Int {
        return api.deleteNote(noteId).code()
    }

}