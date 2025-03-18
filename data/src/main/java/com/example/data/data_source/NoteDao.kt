package com.example.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.utils.Constant.NOTE_TABLE_NAME
import com.example.domain.entities.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM $NOTE_TABLE_NAME")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM $NOTE_TABLE_NAME WHERE id LIKE :noteId")
    suspend fun getNoteById(noteId: Int): Note?

    @Delete
    suspend fun deleteNote(note: Note)
}
