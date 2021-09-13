package by.kos.rsnotesexample.screens.update_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kos.rsnotesexample.model.AppNote
import by.kos.rsnotesexample.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateNoteViewModel(application: Application) : AndroidViewModel(application) {
    fun update(note: AppNote, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.update(note) {
                onSuccess()
            }
        }
}