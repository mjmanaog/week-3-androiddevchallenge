package com.example.androiddevchallenge.helpers

import com.example.androiddevchallenge.R

data class DummyThemesData(val image: Int, val title: String)
data class DummyPlantsData(val image: Int, val title: String, val description: String)

val themesList = arrayListOf(
    DummyThemesData(R.drawable.img_desert_chiq, "Desert chic"),
    DummyThemesData(R.drawable.img_desert_chiq, "Tiny terrariums"),
    DummyThemesData(R.drawable.img_desert_chiq, "Jungle terrariums"),
)


val plantsList = arrayListOf(
    DummyPlantsData(R.drawable.img_desert_chiq, "Monstera", "This is a Description"),
    DummyPlantsData(R.drawable.img_desert_chiq, "Aglaonema", "This is a Description"),
    DummyPlantsData(R.drawable.img_desert_chiq, "Peace lily", "This is a Description"),
    DummyPlantsData(R.drawable.img_desert_chiq, "Fiddle leaf tree", "This is a Description"),
    )