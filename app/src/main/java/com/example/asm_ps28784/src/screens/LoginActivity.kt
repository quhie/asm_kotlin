package com.example.asm_ps28784.src.screens


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.compose.rememberNavController
import com.example.asm_ps28784.R
import com.example.asm_ps28784.src.compoments.HeaderRow
import com.example.asm_ps28784.src.compoments.LoginTextInput

@Composable
fun Login(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(30.dp)
        ) {
            HeaderRow()
            LoginHeader()
        }
        LoginCard(navController)
    }
}
@Composable
fun LoginHeader() {
    Column {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Hello!",
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp,
                color = Color.DarkGray
            )
        )

        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "WELCOME BACK",
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun LoginCard(navController: NavController) {
    val username = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    Log.d(TAG, "LoginCard: $username, $password")

    Spacer(modifier = Modifier.height(20.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp),
        shape = RoundedCornerShape(topEnd = 3.dp, bottomEnd = 3.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Column(
            modifier = Modifier.padding(start = 30.dp)
        ) {
            LoginTextInput(
                value = username.value,
                onValueChange = {username.value = it},
                label = "Email"
            )
            Spacer(modifier = Modifier.height(10.dp))
            LoginTextInput(
                value = password.value,
                onValueChange = { password.value = it },
                label = "Password",
                isPassword = true
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        CardBottom(navController)
    }
}

@Composable
private fun CardBottom(navController: NavController) {
    Column(
        modifier = Modifier.padding(
            start = 30.dp, end = 30.dp, bottom = 25.dp
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(onClick = {}) {
            Text(
                text = "Forgot Password",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(android.graphics.Color.parseColor("#303030")),
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("Home")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 16.dp)
        ) {
            Text(
                text = "Log in",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        TextButton(onClick = {
            navController.navigate("Signup")
        }) {
            Text(
                text = "SIGN UP",
                style = TextStyle(
                    fontSize = 18.sp,
//                    fontFamily = gelasio_regular,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(android.graphics.Color.parseColor("#303030")),
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    Login(rememberNavController())
}
