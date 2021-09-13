package by.kos.rsnotesexample.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import by.kos.rsnotesexample.model.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM notes_table ORDER BY CASE WHEN :criteria = 'name' THEN name  END ASC,"
    +"CASE WHEN :criteria = 'text' THEN text  END ASC,"+
    "CASE WHEN :criteria = 'priority' THEN priority END ASC")
    fun getAllNotes(criteria: String):LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)

    @Update
    suspend fun update(note: AppNote)
}