package com.marekfeifrlik.bscnotes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.marekfeifrlik.api.ApiClient
import com.marekfeifrlik.api.NotesApi
import com.marekfeifrlik.bscnotes.viewmodel.NotesSharedViewModel
import com.marekfeifrlik.common.model.Note
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */

@RunWith(JUnit4::class)
class NotesTests {

    @Mock
    private val application: NotesApp? = null

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    var apiEndPoint: NotesApi? = null
    @Mock
    var apiClient: ApiClient? = null
    @Mock
    var observer: Observer<List<Note>>? = null

    private var viewModel: NotesSharedViewModel? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = NotesSharedViewModel()
        Mockito.spy(viewModel)
    }

    @Test
    fun getTestNotes() {
        viewModel!!.getNotes()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        viewModel = null
    }

}