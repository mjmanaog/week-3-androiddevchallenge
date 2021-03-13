package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.helpers.DummyPlantsData
import com.example.androiddevchallenge.helpers.DummyThemesData
import com.example.androiddevchallenge.helpers.plantsList
import com.example.androiddevchallenge.helpers.themesList
import com.example.androiddevchallenge.ui.components.ReusableImage
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.onSecondary
    ) {
        HomeMain()
    }
}

@Composable
fun HomeMain() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search icon"
                )
            },
            placeholder = { Text(text = "Search", style = MaterialTheme.typography.body1) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Browse themes", style = MaterialTheme.typography.h1)
        Spacer(modifier = Modifier.height(8.dp))
        ThemesList()
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Design your home garden", style = MaterialTheme.typography.h1)
            Image(
                imageVector = Icons.Default.FilterList,
                contentDescription = "Filter List Icon",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        PlantsList()
    }
}

@Composable
fun ThemesList(){
    LazyRow(content = {
        items(themesList){ theme ->
            ThemesCard(themesData = theme)
        }
    })
}

@Composable
fun PlantsList(){
    LazyColumn(content = {
        items(plantsList){ plant ->
           PlantsCard(plantData = plant)
        }
    })
}

@Composable
fun ThemesCard(themesData: DummyThemesData) {
    Card(
        modifier = Modifier
            .height(136.dp)
            .width(148.dp)
            .padding(end = 8.dp),
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            ReusableImage(
                image = themesData.image,
                contentScale = ContentScale.Crop,
                contentDesc = "Themes Image",
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth()
            )
            Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.Center) {
                Text(
                    text = themesData.title,
                    style = MaterialTheme.typography.h2,
                )
            }
        }
    }
}

@Composable
fun PlantsCard(plantData: DummyPlantsData) {
    Card(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        elevation = 0.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Transparent
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            ReusableImage(
                image = plantData.image,
                contentScale = ContentScale.Crop,
                contentDesc = "Plants Image",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(64.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize()
                        .padding(start = 8.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentWidth()
                    ) {
                        Text(text = plantData.title, style = MaterialTheme.typography.h2)
                        Text(text = plantData.description, style = MaterialTheme.typography.body1)
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Checkbox(checked = false, onCheckedChange = { /*TODO*/ })
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 4.dp, end = 8.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Divider()
                }
            }


        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}
