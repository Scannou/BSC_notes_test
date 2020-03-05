package com.marekfeifrlik.api

import com.marekfeifrlik.common.model.Note
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
interface NotesApi {

  @GET("/notes")
  suspend fun getNotesList(): Response<List<Note>>

  @GET("/notes/{id}")
  suspend fun getNote(@Path("id") id: Int): Response<Note>

  @POST("/notes")
  suspend fun postNote(@Body note: Note): Response<Note>

  @PUT("/notes/{id}")
  suspend fun updateNote(@Path("id") id: Int, @Body note: Note): Response<Note>

  @DELETE("/notes/{id}")
  suspend fun deleteNote(@Path("id") id: Int): Response<Void>

}