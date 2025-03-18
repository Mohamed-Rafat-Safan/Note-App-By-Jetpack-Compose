package com.example.noteapp.di

import com.example.domain.repo.NoteRepository
import com.example.domain.use_case.AddNote
import com.example.domain.use_case.DeleteNote
import com.example.domain.use_case.GetNote
import com.example.domain.use_case.GetNotes
import com.example.domain.use_case.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseDbModule {

    @Provides
    fun provideNoteUseCase(noteRepository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNotes = GetNotes(noteRepository),
            deleteNote = DeleteNote(noteRepository),
            addNote = AddNote((noteRepository)),
            getNote = GetNote(noteRepository)
        )
    }

}

