package com.endiel.noteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.endiel.noteapp.feature_note.domain.use_case.DeleteNote

@Composable
fun NoteItem(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(modifier = modifier) {
            Text(text = "28")
            Text(text = "March")
        }
        Column(modifier = modifier) {
            Text(text = "Title")
            Text(text = "Home")
            Text(text = "Notes here here, that's it")
        }
    }
}