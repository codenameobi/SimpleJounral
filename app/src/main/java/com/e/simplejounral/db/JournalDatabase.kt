package com.e.simplejounral.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.e.simplejounral.data.Journal
import com.e.simplejounral.data.JournalDao

@Database(entities = [Journal::class], version = 1, exportSchema = false)
public abstract class JournalDatabase : RoomDatabase() {
    abstract fun JournalDao() : JournalDao

    companion object {
        @Volatile
        private var INSTANCE: JournalDatabase? = null

        fun getDatabase(context: Context): JournalDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JournalDatabase::class.java,
                    "journal_database"
                ).build()
                INSTANCE= instance
                instance
            }
        }
    }

}