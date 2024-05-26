package com.endiel.noteapp.feature_note.domain.util

/**
 * Sealed class restrict inheritance/class hierarchy
 * used when the object have one of the types from limited set, but cannot have any other type
 */
sealed class OrderType {
    data object Ascending: OrderType() // TODO: Nimeweka data object not object, I'll observe this later
    data object Descending: OrderType()
}