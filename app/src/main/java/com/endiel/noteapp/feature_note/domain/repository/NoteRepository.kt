package com.endiel.noteapp.feature_note.domain.repository

import com.endiel.noteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * Interface is a collection of abstract methods and properties that
 * define common contract for classes that implement the interface
 * We need this interface so that we can use it for testing(creating fakeDatabase)
 */
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}