package com.example.asm_ps28784.src.screens


import android.widget.Toast
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.compose.rememberNavController
import com.example.asm_ps28784.R
import com.example.asm_ps28784.src.compoments.HeaderRow
import com.example.asm_ps28784.src.compoments.Validator

@Composable
fun Signup(navController: NavController) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(30.dp)
        ) {
            HeaderRow()
            SignupHeader()
        }
        SignupCard(navController, name, email, password, confirmPassword)
    }
}

@Composable
fun SignupHeader() {
    Column {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "WELCOME",
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
fun SignupTextInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false
) {
    val isPasswordVisible = remember { mutableStateOf(false) }
    val icon = if (isPasswordVisible.value) R.drawable.open_eye_24 else R.drawable.close_eye

    Text(
        text = label,
        modifier = Modifier.padding(top = 5.dp, bottom = 25.dp),
        color = Color.DarkGray,
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .weight(1f),
            visualTransformation = if (isPassword && !isPasswordVisible.value) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text)
        )

        if (isPassword) {
            IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value }) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Visibility Icon"
                )
            }
        }
    }

    Divider()
}

@Composable
fun SignupCard(navController: NavController, name: MutableState<String>, email: MutableState<String>, password: MutableState<String>, confirmPassword: MutableState<String>) {
val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp),
        shape = RoundedCornerShape(topEnd = 3.dp, bottomEnd = 3.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.padding(start = 30.dp)
        ) {
            SignupTextInput(
                value = name.value,
                onValueChange = { name.value = it },
                label = "Name"
            )
            Spacer(modifier = Modifier.height(10.dp))
            SignupTextInput(
                value = email.value,
                onValueChange = { email.value = it },
                label = "Email"
            )
            Spacer(modifier = Modifier.height(10.dp))
            SignupTextInput(
                value = password.value,
                onValueChange = { password.value = it },
                label = "Password",
                isPassword = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            SignupTextInput(
                value = confirmPassword.value,
                onValueChange = { confirmPassword.value = it },
                label = "Confirm Password",
                isPassword = true
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        CardBottom(navController, email, password, confirmPassword)
    }
}

@Composable
private fun CardBottom(navController: NavController, email: MutableState<String>, password: MutableState<String>, confirmPassword: MutableState<String>) {
    Column(
        modifier = Modifier.padding(
            start = 30.dp, end = 30.dp, bottom = 25.dp
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (Validator.isValidEmail(email.value) && Validator.isValidPassword(password.value) && Validator.isPasswordMatch(
                        password.value,
                        confirmPassword.value
                    )
                ) {
                    navController.navigate("login")
                    Toast.makeText(
                        navController.context,
                        "Sign up successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        navController.context,
                        "Invalid email or password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
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
                text = "Sign up",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account?",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                )
            )
            TextButton(onClick = {
                navController.navigate("login")
            }) {
                Text(
                    text = "SIGN IN",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewSignup() {
    Signup(rememberNavController())
}