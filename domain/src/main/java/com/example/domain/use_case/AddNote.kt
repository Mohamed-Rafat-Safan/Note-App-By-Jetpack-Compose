package com.example.domain.use_case

import com.example.domain.entities.InvalidNoteException
import com.example.domain.entities.Note
import com.example.domain.repo.NoteRepository
import kotlin.jvm.Throws

class AddNote(private val noteRepository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty!")
        }

        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty!")
        }

        noteRepository.insertNote(note)
    }

}
