package com.marekfeifrlik.common.model

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
sealed class ListenerType {
    class DetailClickListener(val note: Note): ListenerType()
    class DeleteClickListener(val note: Note): ListenerType()
}