package com.example.asm_ps28784.src.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
fun Home(navController: NavController) {
    val gelasioRegular = FontFamily(Font(R.font.gelasio_regular))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(android.graphics.Color.parseColor("#FFFFFF")))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.search_2),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Make home",
                    color = Color(android.graphics.Color.parseColor("#909090")),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = gelasioRegular,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "beautiful".uppercase(),
                    color = Color(android.graphics.Color.parseColor("#242424")),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = gelasioRegular,
                    textAlign = TextAlign.Center
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.cart_2),
                    contentDescription = "Cart",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(5) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(android.graphics.Color.parseColor("#F5F5F5")))
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "Category",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Category $index",
                        color = Color(android.graphics.Color.parseColor("#303030")),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = gelasioRegular,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(10) { index ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .background(Color(android.graphics.Color.parseColor("#FFFFFF")))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Product",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .align(Alignment.TopCenter)
                                    .height(200.dp)
                            )
                            IconButton(
                                modifier = Modifier
                                    .align(Alignment.BottomEnd),
                                onClick = { /*TODO*/ }) {
                                Image(
                                    painter = painterResource(id = R.drawable.add_cart),
                                    contentDescription = "Favorite",
                                    modifier = Modifier
                                        .size(30.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier
                            .height(8.dp)
                            .padding(8.dp)
                        )
                        Text(
                            text = "Product $index",
                            color = Color(android.graphics.Color.parseColor("#303030")),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = gelasioRegular,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "$ \$",
                            color = Color(android.graphics.Color.parseColor("#303030")),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = gelasioRegular,
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }
        }

    }
}


@Preview
@Composable
fun HomePreview() {
    Home(navController = rememberNavController())
}
