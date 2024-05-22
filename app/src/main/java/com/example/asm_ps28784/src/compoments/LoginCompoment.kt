package com.example.asm_ps28784.src.compoments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.asm_ps28784.R


@Composable
fun HeaderRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Divider(
            color = Color(android.graphics.Color.parseColor("#BDBDBD")),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(0.33f)
                .align(Alignment.CenterVertically)
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .width(63.dp)
                .height(63.dp)
                .align(Alignment.CenterVertically)
        )

        Divider(
            color = Color(android.graphics.Color.parseColor("#BDBDBD")),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .align(Alignment.CenterVertically)
        )

    }
}
@Composable
fun LoginTextInput(
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