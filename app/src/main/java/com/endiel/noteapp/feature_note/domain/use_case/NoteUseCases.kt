package com.endiel.noteapp.feature_note.domain.use_case

// This data class contains note use cases for our dependency injection
data class NoteUseCases(
    // Getting reference of objects
    val getNotes: GetNotes,
    val getNote: GetNote,
    val addNote: AddNote,
    val deleteNote: DeleteNote
)