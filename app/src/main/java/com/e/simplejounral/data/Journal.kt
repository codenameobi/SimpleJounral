package com.e.simplejounral.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "journal_table")
data class Journal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="date")
    val date: LocalDate,
    @ColumnInfo(name = "body")
    val body: String
)
