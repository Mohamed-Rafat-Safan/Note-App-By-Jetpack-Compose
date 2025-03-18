package com.example.domain.use_case

import com.example.domain.entities.Note
import com.example.domain.repo.NoteRepository

class GetNote(
    private val noteRepository: NoteRepository,
) {
    suspend operator fun invoke(noteId: Int): Note? {
        return noteRepository.getNoteById(noteId)
    }
}