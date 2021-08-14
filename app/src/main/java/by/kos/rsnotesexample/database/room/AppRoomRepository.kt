package by.kos.rsnotesexample.database.room

import androidx.lifecycle.LiveData
import by.kos.rsnotesexample.database.DatabaseRepository
import by.kos.rsnotesexample.model.AppNote
import by.kos.rsnotesexample.utils.CRITERIA

class AppRoomRepository(private val appRoomDao: AppRoomDao):DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes(CRITERIA)

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
        onSuccess()
    }

}