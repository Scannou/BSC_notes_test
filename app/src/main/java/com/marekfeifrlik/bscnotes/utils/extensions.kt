package com.marekfeifrlik.bscnotes.utils

import android.view.View

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */

fun View.show() : View {
  if (visibility != View.VISIBLE) {
    visibility = View.VISIBLE
  }
  return this
}

fun View.hide() : View {
  if (visibility != View.INVISIBLE) {
    visibility = View.INVISIBLE
  }
  return this
}