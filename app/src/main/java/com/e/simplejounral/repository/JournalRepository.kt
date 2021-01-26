package com.e.simplejounral.repository

import androidx.annotation.WorkerThread
import com.e.simplejounral.data.Journal
import com.e.simplejounral.db.JournalDao
import kotlinx.coroutines.flow.Flow

class JournalRepository(private val JournalDao: JournalDao) {
    val allJournals: Flow<List<Journal>> = JournalDao.getJournal()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(journal: Journal) {
        JournalDao.insert(journal)
    }
}