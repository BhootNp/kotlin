package com.example.kotlin.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin.R

@Composable
fun HomeScreen() {

    val data = listOf(
        R.drawable.hi1,
        R.drawable.h2,
        R.drawable.hi3,
        R.drawable.hi1,
        R.drawable.hi1,
        R.drawable.hi1,
        R.drawable.hi1
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF6CC))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {

        item {
            Text(
                text = "Good Morning ☀️",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        item {
            SectionTitle("Stories")

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(data.size) { index ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                        modifier = Modifier.size(85.dp)
                    ) {
                        Image(
                            painter = painterResource(data[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }

        // Feature Banner
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.hi3),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }

        // Recommended Row
        item {
            SectionTitle("Recommended for you")

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(data.size) { index ->
                    Card(
                        shape = RoundedCornerShape(14.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                        modifier = Modifier.size(100.dp)
                    ) {
                        Image(
                            painter = painterResource(data[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }

        // Grid Items
        item {
            SectionTitle("Popular Items")

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier
                    .height(420.dp)
                    .fillMaxWidth()
            ) {
                items(data.size) { index ->
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(6.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Image(
                            painter = painterResource(data[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}
