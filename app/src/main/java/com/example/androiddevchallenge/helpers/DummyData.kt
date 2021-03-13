package com.example.androiddevchallenge.helpers

import com.example.androiddevchallenge.R

data class DummyThemesData(val image: Int, val title: String)
data class DummyPlantsData(val image: Int, val title: String, val description: String)

val themesList = arrayListOf(
    DummyThemesData(R.drawable.img_desert_chiq, "Desert chic"),
    DummyThemesData(R.drawable.img_desert_chiq, "Tiny terrariums"),
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