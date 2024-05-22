package com.example.asm_ps28784.src.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.asm_ps28784.R

@Composable
fun Boarding(navController: NavController) {
    val image = painterResource(R.drawable.bg_boarding)

    val gelasio_regular = FontFamily(
        Font(R.font.gelasio_regular)
    )

    val nunito_regular = FontFamily(
        Font(R.font.nunitosans_regular)
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = image,
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 18.dp, top = 8.dp, end = 18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "MAKE YOUR".uppercase(),
                color = Color(android.graphics.Color.parseColor("#606060")),
                fontSize = 24.sp,
                fontFamily = gelasio_regular,
                modifier = Modifier.padding(bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
            Text(
                text = "HOME BEAUTIFUL".uppercase(),
                color = Color(android.graphics.Color.parseColor("#303030")),
                fontSize = 30.sp,
                fontFamily = nunito_regular,
                modifier = Modifier.padding(bottom = 8.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
            Text(

                text = "The best simple place where you discover most wonderful furniture's and make your home beautiful.",
                color = Color(android.graphics.Color.parseColor("#808080")),
                fontSize = 18.sp,
                fontFamily = nunito_regular,
                modifier = Modifier.padding(
                    start = 20.dp,
                ),
                textAlign = TextAlign.Start,
                maxLines = 3,
                lineHeight = 28.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate("HOME")
                },
                modifier = Modifier
                    .width(160.dp)
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(8.dp),
            ) {
                Text(
                    "Get Started",
                    style = TextStyle(
//                        fontFamily = FontFamily.Serif,
                        fontSize = 18.sp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoardingPreview() {
    val navController = rememberNavController()
    Boarding(navController)
}