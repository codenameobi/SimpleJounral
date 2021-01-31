package com.e.simplejounral.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.e.simplejounral.data.Journal
import com.e.simplejounral.utils.DateConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@Database(entities = [Journal::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
public abstract class JournalDatabase : RoomDatabase() {
    abstract fun JournalDao() : JournalDao

    private class JournalDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.JournalDao())
                }
            }
        }

        suspend fun populateDatabase(JournalDao: JournalDao) {
            JournalDao.deleteAll()
            var date =  Date()
            val journal = Journal(1,"firstnote",  date ,"full text" )
            JournalDao.insert(journal)
            val journal2 = Journal(2,"secondnote",  date ,"full text" )
            JournalDao.insert(journal2)

        }
    }



    companion object {
        @Volatile
        private var INSTANCE: JournalDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): JournalDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database


            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JournalDatabase::class.java,
                    "journal_database"
                ).addCallback(JournalDatabaseCallback(scope)).build()
                INSTANCE= instance
                instance
            }
        }
    }

}