package com.endiel.noteapp.feature_note.presentation.add_edit_note.components

/**
 * This class contains states of how the AddEditScreen will look like and or behave
 * data class on contains states(as for this case), and does not perform any action
 * it gives us an immense amount of self generated codes
 */
data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)