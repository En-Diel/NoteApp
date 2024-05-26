package com.endiel.noteapp.feature_note.presentation.notes.components

import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.util.NoteOrder

/**
 * This is a class that contains all events of a note
 * Sealed class restrict inheritance/class hierarchy
 * used when the object have one of the types from limited set, but cannot have any other type
 */
sealed class NotesEvents {
    data class Order(val noteOrder: NoteOrder): NotesEvents()
    data class Delete(val note: Note): NotesEvents()
    data object Restore: NotesEvents()
    data object ToggleOrderSection: NotesEvents()
}