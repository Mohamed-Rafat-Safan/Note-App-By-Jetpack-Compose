package com.example.data.repo

import com.example.data.data_source.NoteDao
import com.example.domain.entities.Note
import com.example.domain.repo.NoteRepository
import kotlinx.coroutines.flow.Flow


class NoteRepositoryImpl(
    private val noteDao: NoteDao,
) : NoteRepository {

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override fun getNotes(): Flow<List<Note>> = noteDao.getNotes()


    override suspend fun getNoteById(noteId: Int): Note? = noteDao.getNoteById(noteId)


    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

}