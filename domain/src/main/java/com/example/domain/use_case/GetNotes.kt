package com.example.domain.use_case

import com.example.core.utils.NoteOrder
import com.example.core.utils.OrderType
import com.example.domain.entities.Note
import com.example.domain.repo.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val noteRepository: NoteRepository,
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    ): Flow<List<Note>> {

        return noteRepository.getNotes().map { listNote ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> listNote.sortedBy { it.title.lowercase() }

                        is NoteOrder.Date -> listNote.sortedBy { it.timesTamp }

                        is NoteOrder.Color -> listNote.sortedBy { it.color }
                    }
                }

                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> listNote.sortedByDescending { it.title.lowercase() }

                        is NoteOrder.Date -> listNote.sortedByDescending { it.timesTamp }

                        is NoteOrder.Color -> listNote.sortedByDescending { it.color }
                    }
                }
            }
        }

    }

}