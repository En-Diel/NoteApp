package com.endiel.noteapp.feature_note.presentation.notes.components

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.endiel.noteapp.feature_note.domain.model.Note

@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    onDeleteClick: () -> Unit
) {
    val dateDay = SimpleDateFormat("dd").format(note.timeStamp)
    val dateMonth = SimpleDateFormat("MM").format(note.timeStamp)
    Card(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 8.dp
            )
    ) {
        Row(
            modifier = modifier
                .background(color = Color(note.color)),
            Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(
                        alignment = Alignment.CenterVertically
                    )
            ) {
                // TODO: Hapa ntaformat date iwe kwenye mfumo wa tarehe na mwezi(abbreviated)
                Text(text = dateDay)
                Text(text = dateMonth)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = note.title,
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis // This puts dots to when text exceeds
                )
                /*Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.inverseOnSurface)) {
                    Text(text = "Category")
                }*/
                Text(
                    text = note.content,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis // This puts dots to when text exceeds
                )
            }
            IconButton(
                onClick = onDeleteClick,
                modifier = Modifier
                    .align(alignment = Alignment.Bottom)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Note"
                )
            }
        }
    }
}