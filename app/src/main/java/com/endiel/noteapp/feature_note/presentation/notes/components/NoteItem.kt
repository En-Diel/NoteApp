package com.endiel.noteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.presentation.notes.NotesViewModel

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 8.dp
            )
    ) {
        Row(modifier = modifier.background(color = Color(note.color)), Arrangement.SpaceBetween) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Blue)
                    .align(
                        alignment = Alignment.CenterVertically
                    )
            ) {
                Text(text = "23")
                Text(text = "October")
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Yellow)
            ) {
                Text(text = note.title)
                Text(text = "Category")
                Text(text = note.content)
            }
            IconButton(
                onClick = onDeleteClick,
                modifier = Modifier
                    .background(Color.Cyan)
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Note"
                )
            }
        }
    }
}