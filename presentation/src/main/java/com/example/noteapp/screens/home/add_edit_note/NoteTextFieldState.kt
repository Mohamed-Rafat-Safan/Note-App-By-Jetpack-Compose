package com.example.noteapp.screens.home.add_edit_note

data class NoteTextFieldState(
    var text: String = "",
    var hint: String= "",
    var isHintVisible: Boolean = false,
)