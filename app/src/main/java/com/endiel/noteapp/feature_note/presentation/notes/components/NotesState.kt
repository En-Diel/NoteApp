package com.endiel.noteapp.feature_note.presentation.notes.components

import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.util.NoteOrder
import com.endiel.noteapp.feature_note.domain.util.OrderType

/**
 * This data class will contain all the states of a note
 * This represents the current ui state as we want to show it
 * We will save these in our viewModel so as it will survive the scree rotation
 * 1. We need to save a list of database that we load from database
 * 2. We need to show a current radio button selection(A current note order)
 * 3. We want to have a state that decides if the order section is visible or not
 * as we can collapse and expand it
 */
data class NotesState(
    // The note list will be empty by default
    val notes: List<Note> = emptyList(),
    // This will decide about the radio buttons
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending),
    // This will decide about the order section visibility
    val isOrderSectionVisible: Boolean = false
)
/**
 * This is how it works!
 * For instance we click a button on our ui (say a radio button) then this fires
 * an event in viewModel and then viewModel will check for a corresponding use case
 * for that event, call it and then the action is executed
 * But: It's not always linked to a use case
 */
