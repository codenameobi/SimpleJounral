package com.e.simplejounral.di

import android.app.Application
import com.e.simplejounral.db.JournalDatabase
import com.e.simplejounral.repository.JournalRepository

class JournalsApplication : Application() {
    val database by lazy { JournalDatabase.getDatabase(this) }
    val repository by lazy { JournalRepository(database.JournalDao()) }

}