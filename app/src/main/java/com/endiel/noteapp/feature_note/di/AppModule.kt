package com.endiel.noteapp.feature_note.di

import android.app.Application
import androidx.room.Room
import com.endiel.noteapp.feature_note.data.data_source.NoteDatabase
import com.endiel.noteapp.feature_note.data.repository.NoteRepositoryImplementation
import com.endiel.noteapp.feature_note.domain.repository.NoteRepository
import com.endiel.noteapp.feature_note.domain.use_case.AddNote
import com.endiel.noteapp.feature_note.domain.use_case.DeleteNote
import com.endiel.noteapp.feature_note.domain.use_case.GetNote
import com.endiel.noteapp.feature_note.domain.use_case.GetNotes
import com.endiel.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {

    @Provides
    @Singleton
    fun provideNoteDatebase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImplementation(db.noteDao)
    }

    @Provides
    @Singleton
    // TODO: I omit the contractor modifier (repository: NoteRepository) here,
    //  since I got some errors. And I'll not pass the repository as argument
    //  in the UseCases objects below. I'll observe if the injection will work or not
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(),
            getNote = GetNote(),
            addNote = AddNote(),
            deleteNote = DeleteNote()
        )
    }
}