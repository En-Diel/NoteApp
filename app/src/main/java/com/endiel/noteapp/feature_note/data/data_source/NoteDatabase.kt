package com.endiel.noteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.endiel.noteapp.feature_note.domain.model.Note

@Database(entities = [Note::class], version = 1)
// Abstract class means, the class cannot be instantiated. But it's properties can be
// instantiated unless they're declared as abstract
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "note_db"
    }
}