package by.kos.rsnotesexample.database.cursors

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase


private val DB_NAME = "database.db"
private val DB_VERSION = 1

class NotesDBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(NotesContract.NotesEntry.CREATE_COMMAND)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(NotesContract.NotesEntry.DROP_COMMAND)
        onCreate(db)
    }
}