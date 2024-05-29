package com.endiel.noteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.endiel.noteapp.feature_note.domain.model.Note
import com.endiel.noteapp.feature_note.domain.use_case.DeleteNote

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    onDelete: () -> Unit
) {
    Card() {
        Row() {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "23")
                    Text(text = "October")
                }
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .background(Color.Yellow)
            ) {
                Text(text = "Wake up early")
                Text(text = "Category")
                Text(text = "Body of the note")
            }
            IconButton(
                onClick = { onDelete },
                modifier = Modifier
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Note")
            }
        }
    }
}

@Preview
@Composable
fun NoteItem() {
    
}