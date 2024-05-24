package com.endiel.noteapp.feature_note.domain.use_case

import com.endiel.noteapp.feature_note.data.data_source.NoteDao
import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.repository.NoteRepository

// This class contains a function that delete a note
class DeleteNote {
    // TODO: Instead of making the clas a function,
    //  let me go with the normal function inside the class here and see what happens
    suspend fun deleteNote(repository: NoteRepository, note: Note) {
        repository.deleteNote(note)
    }
}