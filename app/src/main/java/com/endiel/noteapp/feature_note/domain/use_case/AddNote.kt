package com.endiel.noteapp.feature_note.domain.use_case

import com.endiel.noteapp.feature_note.domain.model.InvalidNoteException
import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.repository.NoteRepository

// This class contains a function to add a note
class AddNote {
    suspend fun addNote(repository: NoteRepository, note: Note) {
        // Let's check before a note is added
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title can't be empty")
        }
        if (note.body.isBlank()) {
            throw InvalidNoteException("Body can't be empty")
        }
        repository.insertNote(note)
    }
}