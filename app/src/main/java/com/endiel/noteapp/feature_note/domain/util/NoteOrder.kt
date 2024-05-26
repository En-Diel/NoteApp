package com.endiel.noteapp.feature_note.domain.util

/**
 * Sealed class restrict inheritance/class hierarchy
 * used when the object have one of the types from limited set, but cannot have any other type
 */
sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): NoteOrder(orderType)
    class Date(orderType: OrderType): NoteOrder(orderType)
    class Color(orderType: OrderType): NoteOrder(orderType)
}