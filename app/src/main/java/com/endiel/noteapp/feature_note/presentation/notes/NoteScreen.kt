package com.endiel.noteapp.feature_note.presentation.notes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NoteScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
) {
    Text(text = "Note Screen")
}