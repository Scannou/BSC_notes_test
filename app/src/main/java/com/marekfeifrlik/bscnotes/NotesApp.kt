package com.marekfeifrlik.bscnotes

import android.app.Application

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
class NotesApp : Application() {
    // This class is kinda pointless... in a bigger project I'd host
    // all major init and sync functions here.

    init {
        instance = this
    }

    companion object {
        private var instance: NotesApp? = null

        fun applicationContext() : NotesApp {
            return instance as NotesApp
        }
    }

}