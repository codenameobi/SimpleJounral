package com.e.simplejounral.ui.viewmodel

import androidx.lifecycle.*
import com.e.simplejounral.data.Journal
import com.e.simplejounral.repository.JournalRepository
import kotlinx.coroutines.launch

class JournalViewModel(private val repository: JournalRepository) : ViewModel() {
    val allJournals: LiveData<List<Journal>> = repository.allJournals.asLiveData()

    fun insert(journal: Journal) = viewModelScope.launch {
        repository.insert(journal)
    }

    class JournalViewModelFactory(private val repository: JournalRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(JournalViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return JournalViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}