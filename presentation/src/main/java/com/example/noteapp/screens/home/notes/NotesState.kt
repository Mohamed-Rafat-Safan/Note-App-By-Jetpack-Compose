package com.example.noteapp.screens.home.notes

import com.example.core.utils.NoteOrder
import com.example.core.utils.OrderType
import com.example.domain.entities.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
)
