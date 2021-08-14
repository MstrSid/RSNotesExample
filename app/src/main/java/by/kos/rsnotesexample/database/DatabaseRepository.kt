package by.kos.rsnotesexample.database

import androidx.lifecycle.LiveData
import by.kos.rsnotesexample.model.AppNote

interface DatabaseRepository {
    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess:()->Unit)
    suspend fun delete(note: AppNote, onSuccess:()->Unit)
}