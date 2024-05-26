package com.endiel.noteapp.feature_note.domain.use_case

import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.repository.NoteRepository

// This class contains a function that returns a note by it's id
class GetNote(private val repository: NoteRepository) {

    // We put type Note so as it also helps to know which id we use(that it is of a note id)
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}