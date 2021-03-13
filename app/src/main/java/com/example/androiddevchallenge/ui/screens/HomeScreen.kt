/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.helpers.DummyPlantsData
import com.example.androiddevchallenge.helpers.DummyThemesData
import com.example.androiddevchallenge.helpers.plantsList
import com.example.androiddevchallenge.helpers.themesList
import com.example.androiddevchallenge.ui.components.ReusableImage

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 40.dp),
        color = MaterialTheme.colors.onSecondary
    ) {
        HomeMain()
    }
}

@Composable
fun HomeMain() {
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
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
fun ThemesList() {
    LazyRow(
        content = {
            items(themesList) { theme ->
                ThemesCard(themesData = theme)
            }
        }
    )
}

@Composable
fun PlantsList() {
    LazyColumn(
        content = {
            items(plantsList) { plant ->
                PlantsCard(plantData = plant)
            }
        }
    )
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
                        .padding(start = 4.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Divider()
                }
            }
        }
    }
}
