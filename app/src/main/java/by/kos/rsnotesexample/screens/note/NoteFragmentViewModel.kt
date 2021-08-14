package by.kos.rsnotesexample.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import by.kos.rsnotesexample.model.AppNote
import by.kos.rsnotesexample.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application):AndroidViewModel(application) {
    fun delete(note: AppNote, onSuccess:()->Unit)=
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(note){
                onSuccess()
            }
        }
}