package com.marekfeifrlik.common.model

import java.lang.Exception

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
sealed class Output<out T : Any> {
    data class Success<out T : Any>(val output : T) : Output<T>()
    data class Error(val exception: Exception)  : Output<Nothing>()
}