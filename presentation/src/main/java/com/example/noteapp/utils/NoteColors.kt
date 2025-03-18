package com.example.noteapp.utils

import androidx.compose.ui.graphics.Color
import com.example.noteapp.ui.theme.*

object NoteColors {
    operator fun invoke(): List<Color> {
        return listOf(
            RedOrange,
            RedPink,
            BabyBlue,
            Violet,
            LightGreen
        )
    }
}