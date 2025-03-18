package com.example.domain.use_case

import com.example.domain.entities.Note
import com.example.domain.repo.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository,
) {
    suspend operator fun invoke(note: Note) {
        return noteRepository.deleteNote(note)
    }
}