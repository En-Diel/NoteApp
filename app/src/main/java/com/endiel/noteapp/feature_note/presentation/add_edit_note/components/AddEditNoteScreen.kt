package com.endiel.noteapp.feature_note.presentation.add_edit_note.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.endiel.noteapp.feature_note.presentation.notes.NotesViewModel

@Composable
fun AddEditNoteScreen(
    navController: NavController,
    noteColor: Int,
    viewModel: NotesViewModel = hiltViewModel()
) {
    Text(text = "This is Add Edit Note Screen")
}