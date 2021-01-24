package com.e.simplejounral.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal_table ORDER BY id ASC")
    fun getJournal(): List<Journal>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(journal: Journal)

    @Query("DELETE FROM journal_table")
    suspend fun deleteAll()
}