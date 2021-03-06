package by.kos.rsnotesexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes_table")
data class AppNote(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    var name: String = "",

    @ColumnInfo
    var text: String = "",

    @ColumnInfo
    var priority: Int = 0
): Serializable