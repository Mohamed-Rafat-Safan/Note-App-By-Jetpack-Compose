package com.example.domain.repo

import com.example.domain.entities.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(note: Note)

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(noteId: Int): Note?

    suspend fun deleteNote(note: Note)
}