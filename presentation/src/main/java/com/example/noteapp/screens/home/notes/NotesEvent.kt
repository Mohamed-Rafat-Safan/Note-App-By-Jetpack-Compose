package com.example.noteapp.screens.home.notes

import com.example.core.utils.NoteOrder
import com.example.domain.entities.Note

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}
