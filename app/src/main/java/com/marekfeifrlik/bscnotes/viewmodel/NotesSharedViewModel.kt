package com.marekfeifrlik.bscnotes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marekfeifrlik.api.ApiClient
import com.marekfeifrlik.api.NotesApi
import com.marekfeifrlik.bscnotes.repositories.NotesRepository
import com.marekfeifrlik.common.model.Note
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
class NotesSharedViewModel : ViewModel() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.IO
    private val scope = CoroutineScope(coroutineContext)
    private val apiClient: ApiClient = ApiClient()
    private val notesApi: NotesApi = apiClient.getRetrofit().create(NotesApi::class.java)
    private val notesRepository: NotesRepository = NotesRepository(notesApi)
    val notesListLiveData = MutableLiveData<MutableList<Note>>()
    val noteLiveData = MutableLiveData<Note>()
    var statusMsg = MutableLiveData<String>()

    fun getNotes() {
        scope.launch {
            try {
                val notes = notesRepository.getNotes()
                notesListLiveData.postValue(notes)
//                statusMsg.postValue("Data loaded")
            } catch (e: Exception) {
                statusMsg.postValue("Error occurred")
            }
        }
    }

    fun getNote(id: Int) {
        scope.launch {
            val note = notesRepository.getNote(id)
            noteLiveData.postValue(note)
        }
    }

    fun saveNote(note: Note) {
        scope.launch {
            try {
                notesRepository.saveNote(note)
                statusMsg.postValue("Note saved")
            } catch (e: Exception) {
                statusMsg.postValue("Error saving note")
            }
        }
    }

    fun updateNote(note: Note) {
        scope.launch {
            try {
                notesRepository.updateNote(note)
                statusMsg.postValue("Note updated")
            } catch (e: Exception) {
                statusMsg.postValue("Error updating note")
            }
        }
    }

    fun deleteNote(noteId: Int) {
        scope.launch {
            try {
                notesRepository.deleteNote(noteId)
                statusMsg.postValue("Note deleted")
            } catch (e: java.lang.Exception) {
                statusMsg.postValue("Error occurred")
            }
        }
    }

    fun cancelRequests() = coroutineContext.cancel()

}