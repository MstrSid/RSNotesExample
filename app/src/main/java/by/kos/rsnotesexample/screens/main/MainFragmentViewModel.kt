package by.kos.rsnotesexample.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import by.kos.rsnotesexample.utils.REPOSITORY

class MainFragmentViewModel(application: Application):AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
}