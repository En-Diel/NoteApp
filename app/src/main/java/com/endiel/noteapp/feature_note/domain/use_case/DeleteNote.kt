package com.endiel.noteapp.feature_note.domain.use_case

import com.endiel.noteapp.feature_note.data.data_source.NoteDao
import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.repository.NoteRepository

// This class contains a function that delete a note
class DeleteNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}