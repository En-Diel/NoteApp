package com.endiel.noteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.endiel.noteapp.feature_note.domain.model.Note

// TODO: I added exportSchema = false to get rid of errors, so I'll uncheck it later
@Database(entities = [Note::class], version = 1, exportSchema = false)
/**
 * Abstract class means, the class cannot be instantiated. But it's properties can be
 * instantiated unless they're declared as abstract
 */
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "note_db"
    }
}