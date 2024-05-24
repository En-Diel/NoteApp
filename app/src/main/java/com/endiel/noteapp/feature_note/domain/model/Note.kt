package com.endiel.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.endiel.noteapp.ui.theme.Blue
import com.endiel.noteapp.ui.theme.Green
import com.endiel.noteapp.ui.theme.Orange
import com.endiel.noteapp.ui.theme.Pink
import com.endiel.noteapp.ui.theme.Red

@Entity
data class Note(
    val title: String,
    val body: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    // A special object that is tied to a class, rather than an instance of a class
    // It serves as a way to define static methods/properties of a class
    // This is like a static member. Can be accessed before any objects
    // of its class are created and without any reference to any object
    companion object {
        // This is immutable list(can't be edited)
        val noteColors = listOf(Red, Blue, Pink, Green, Orange)
    }
}
