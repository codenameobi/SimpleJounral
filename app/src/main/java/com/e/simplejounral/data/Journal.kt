package com.e.simplejounral.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "journal_table")
data class Journal(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        @ColumnInfo(name="title")
        val title: String,
        @ColumnInfo(name="date")
        val date: Long,
        @ColumnInfo(name = "body")
        val body: String
)
