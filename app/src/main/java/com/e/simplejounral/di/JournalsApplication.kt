package com.e.simplejounral.di

import android.app.Application
import com.e.simplejounral.db.JournalDatabase
import com.e.simplejounral.repository.JournalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class JournalsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { JournalDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { JournalRepository(database.JournalDao()) }

}