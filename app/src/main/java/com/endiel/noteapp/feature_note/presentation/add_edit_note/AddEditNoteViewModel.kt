package com.endiel.noteapp.feature_note.presentation.add_edit_note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endiel.noteapp.feature_note.domain.model.InvalidNoteException
import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    // This is a bundle that contains note id and many more stuffs
    savedStateHandle: SavedStateHandle
): ViewModel() {
    // Remember the state of the hint in title Fields
    private val _noteTitle = mutableStateOf(NoteTextFieldState(hint = "Enter title..."))
    // To survive the screen rotation
    val noteTitle: State<NoteTextFieldState> = _noteTitle

    // Remember the state of the hint in noteContent
    private val _noteContent = mutableStateOf(NoteTextFieldState(hint = "Enter some content..."))
    // To survive the screen rotation
    val noteContent: State<NoteTextFieldState> = _noteContent

    // Remember the state of the color(color selected)
    private val _noteColor = mutableIntStateOf(Note.noteColors.random().toArgb())
    // To survive the screen rotation
    val noteColor: State<Int> = _noteColor

    // We use MutableSharedFlow when we have events that aren't tied to a particular state eg. one time events(snackBar etc.)
    // or if we need some advanced features like buffering, replaying etc.
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    // Declare noteId value and initialize it to null
    private var currentNoteId: Int? = null

    // This is where we extract the id of the note from "savedStateHandle"
    // With init everything in here will be initialized before any variable is initialized
    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            // We check if noteId is note equal to the previous noteId
            if (noteId != -1) {
                viewModelScope.launch {
                    noteUseCases.getNote(noteId)?.also { note ->
                        // We assign the currentId to the ID of the note that we will create
                        currentNoteId = note.id
                        _noteTitle.value = noteTitle.value.copy(
                            text = note.title,
                            isHintVisible = false
                        )
                        _noteContent.value = noteContent.value.copy(
                            text = note.title,
                            isHintVisible = false
                        )
                        _noteColor.value = note.color
                    }
                }
            }
        }
    }
    fun onEvent(event: AddEditNoteEvent)  {
        when(event) {
            is AddEditNoteEvent.EnteredTitle -> {
                // Copy retains an original object and returns and an immutable copy of it
                _noteTitle.value = noteTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.changeFocus.isFocused &&
                            noteTitle.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.EnteredContent -> {
                _noteContent.value = noteContent.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeContentFocus -> {
                _noteContent.value = noteContent.value.copy(
                    isHintVisible = !event.changeFocus.isFocused &&
                            noteContent.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.ChangeColor -> {
                _noteColor.value = event.color
            }
            is AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNote(
                            Note(
                                title = noteTitle.value.text,
                                content = noteContent.value.text,
                                timeStamp = System.currentTimeMillis(),
                                color = noteColor.value,
                                id = currentNoteId
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)
                    }catch (e: InvalidNoteException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                message = e.message ?: "Couldn't save note"
                            )
                        )
                    }
                }
            }
        }
    }
    sealed class UiEvent() {
        data class ShowSnackBar(val message: String): UiEvent()
        data object SaveNote: UiEvent()
    }
}