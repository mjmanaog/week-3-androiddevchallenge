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
package com.example.androiddevchallenge.helpers

import com.example.androiddevchallenge.R

data class DummyThemesData(val image: Int, val title: String)
data class DummyPlantsData(val image: Int, val title: String, val description: String)

val themesList = arrayListOf(
    DummyThemesData(R.drawable.img_desert_chic, "Desert chic"),
    DummyThemesData(R.drawable.img_tiny_terrarium, "Tiny terrariums"),
    DummyThemesData(R.drawable.img_jungle_vibes, "Jungle vibes"),
    DummyThemesData(R.drawable.img_easy_care, "Easy care"),
    DummyThemesData(R.drawable.img_statements, "Statements"),
)

val plantsList = arrayListOf(
    DummyPlantsData(R.drawable.img_mostera, "Monstera", "This is a Description"),
    DummyPlantsData(R.drawable.img_aglaonema, "Aglaonema", "This is a Description"),
    DummyPlantsData(R.drawable.img_peace_lily, "Peace lily", "This is a Description"),
    DummyPlantsData(R.drawable.img_fiddle, "Fiddle leaf tree", "This is a Description"),
    DummyPlantsData(R.drawable.img_snake_plant, "Snake plant", "This is a Description"),
    DummyPlantsData(R.drawable.img_pothos, "Pothos", "This is a Description"),
)
