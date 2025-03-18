package com.example.noteapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteapp.screens.auth.SplashScreen
import com.example.noteapp.screens.home.add_edit_note.AddEditNoteScreen
import com.example.noteapp.screens.home.notes.NotesScreen
import com.example.noteapp.utils.Screen

@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }


        composable(route = Screen.NotesScreen.route) {
            NotesScreen(navController)
        }

        composable(
            route = Screen.AddEditNoteScreen.route +
                    "?noteId={noteId}&noteColor={noteColor}",
            arguments = listOf(
                navArgument(name = "noteId") {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(name = "noteColor") {
                    type = NavType.IntType
                    defaultValue = -1
                },
            )
        ) {
            val noteColor = it.arguments?.getInt("noteColor") ?: -1
            AddEditNoteScreen(
                navController = navController,
                noteColor = noteColor
            )
        }

//        composable(route = "LoginScreen") {
//            LoginScreen(navController)
//        }
//
//        composable(route = "RegisterScreen") {
//            RegisterScreen(navController)
//        }


    }
}