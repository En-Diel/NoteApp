package com.endiel.noteapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// This class for dependency injection is registered in the manifest file
@HiltAndroidApp
class NoteApp: Application()