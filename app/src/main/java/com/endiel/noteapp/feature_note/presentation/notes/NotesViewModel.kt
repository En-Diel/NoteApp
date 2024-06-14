package com.endiel.noteapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.use_case.NoteUseCases
import com.endiel.noteapp.feature_note.domain.util.NoteOrder
import com.endiel.noteapp.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel()  {

    // This state contains the values that our ui can observe
    // This is so that the ui can survive screen rotation
    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state
    // Recently deleted note reference(null by default)
    private var recentlyDeletedNote: Note? = null
    // This init will load the notes before any variable is created in this class
    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when(event) {
            is NotesEvent.Order -> {
                // We check if the order changed When we
                // click on a radio button that is already checked we don't wanna do nothing
                // We compare classes because if we remove class
                // (then it will be like a referential equality)
                // And referential equality is when we compare two references pointing at the
                // same object(which in our case it's not)
                // as event was written to change the order
                if(state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType)
                {
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.DeleteNote -> {
                // viewModelScope is tied to a viewModel's lifecycle which means
                // any coroutine launched within the viewModel scope will automatically
                // be cancelled when the asociated viewModel is destroyed
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    // Get a reference of a deleted note for undo uses
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    // Set the recentDeletedNote to null to prevent restore/adding a note again
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        val useCases = noteUseCases.getNotes(noteOrder).onEach { notes ->
            _state.value = state.value.copy(
                notes = notes,
                noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }
}