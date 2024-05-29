package com.endiel.noteapp.feature_note.presentation.util

// This class contains a list of screens to navigate to
sealed class Screen(val route: String) {
    data object NoteScreen: Screen("notes_screen")
    data object AddEditNoteScreen: Screen("add_edit_note_screen")
}