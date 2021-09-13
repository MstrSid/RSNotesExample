package by.kos.rsnotesexample.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import by.kos.rsnotesexample.database.cursors.NotesDBHelper
import by.kos.rsnotesexample.utils.*

class MainFragmentViewModel(application: Application):AndroidViewModel(application) {
    val dbHelper = NotesDBHelper(application)
    val allNotes = REPOSITORY.allNotes
}