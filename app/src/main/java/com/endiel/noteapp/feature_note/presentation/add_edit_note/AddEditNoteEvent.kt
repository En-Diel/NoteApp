package com.endiel.noteapp.feature_note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

/**
 * This class contains the events that may occur in our AddEditNote
 */
sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String): AddEditNoteEvent()
    data class ChangeTitleFocus(val changeFocus: FocusState): AddEditNoteEvent()
    data class EnteredContent(val value: String): AddEditNoteEvent()
    data class ChangeContentFocus(val changeFocus: FocusState): AddEditNoteEvent()
    data class ChangeColor(val color: Int): AddEditNoteEvent()
    data object SaveNote: AddEditNoteEvent()
}
