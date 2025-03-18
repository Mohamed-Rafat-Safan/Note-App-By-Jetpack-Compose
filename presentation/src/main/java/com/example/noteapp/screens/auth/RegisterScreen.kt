package com.example.noteapp.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen(navController: NavController){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        MyLogoImage()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "SignUp",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))

        MyTextFieldComponent("Your Name", Icons.Filled.Person)
        Spacer(modifier = Modifier.height(10.dp))
        MyTextFieldComponent("Email", Icons.Filled.Email)
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextFieldComponent("Password", Icons.Filled.Lock)
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextFieldComponent("Confirm Password", Icons.Filled.Lock)


        Spacer(modifier = Modifier.height(40.dp))

        BottomComponent(
            textQuery = "Do you have an account? ",
            textClickable = "Login",
            action = "Register",
            navController
        )
    }
    
}




@Preview(showSystemUi = true)
@Composable
fun ShowCompos() {
    RegisterScreen(rememberNavController())
}