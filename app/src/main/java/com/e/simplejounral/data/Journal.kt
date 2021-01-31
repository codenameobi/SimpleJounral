package com.e.simplejounral.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.e.simplejounral.utils.DateConverter
import java.util.Date
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "journal_table")
data class Journal(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="date")
    val date: Date?,
    @ColumnInfo(name = "body")
    val body: String
)
