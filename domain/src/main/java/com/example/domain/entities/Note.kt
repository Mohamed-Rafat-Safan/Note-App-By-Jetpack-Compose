package com.example.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.utils.Constant.NOTE_TABLE_NAME

@Entity(tableName = NOTE_TABLE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String,
    val timesTamp: Long,
    val color: Int,
)


class InvalidNoteException(message: String) : Exception(message)