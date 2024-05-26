package com.endiel.noteapp.feature_note.domain.use_case

import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.repository.NoteRepository
import com.endiel.noteapp.feature_note.domain.util.NoteOrder
import com.endiel.noteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// This class contains a function that gets all the notes from our database
class GetNotes(private val repository: NoteRepository) {
    // This operator invoke enables us to use the class as a function
    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending)): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
            }
        }
    }
}