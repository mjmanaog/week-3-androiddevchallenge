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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.helpers.ROUTE_LOGIN_SCREEN
import com.example.androiddevchallenge.ui.components.ReusableImage

@Composable
fun WelcomeScreen(navController: NavController?) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        WelcomeMain(clickAction = { navController?.navigate(ROUTE_LOGIN_SCREEN) })
    }
}

@Composable
fun WelcomeMain(clickAction: () -> Unit) {
    val isLightTheme = MaterialTheme.colors.isLight
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize()) {
                ReusableImage(
                    image = if (isLightTheme) R.drawable.light_welcome_bg else R.drawable.dark_welcome_bg,
                    contentScale = ContentScale.Crop,
                    contentDesc = "Welcome BG",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        ReusableImage(
                            image = if (isLightTheme) R.drawable.light_welcome_illos else R.drawable.dark_welcome_illos,
                            contentScale = ContentScale.Fit,
                            contentDesc = "Welcome Illos Image",
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(bottom = 32.dp, top = 72.dp)
                                .offset(48.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ReusableImage(
                            image = if (isLightTheme) R.drawable.light_logo else R.drawable.dark_logo,
                            contentScale = ContentScale.Fit,
                            contentDesc = "Logo",
                            modifier = Modifier
                        )
                        Text(
                            text = "Beautiful home garden solutions",
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier.padding(bottom = 40.dp)
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            shape = MaterialTheme.shapes.medium,
                            colors = ButtonDefaults.textButtonColors(
                                backgroundColor = MaterialTheme.colors.secondary,
                                contentColor = MaterialTheme.colors.onSecondary
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Text(text = "Create account", style = MaterialTheme.typography.button)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        TextButton(onClick = clickAction) {
                            Text(
                                text = "Login",
                                style = MaterialTheme.typography.button,
                                color = MaterialTheme.colors.secondary
                            )
                        }
                    }
                }
            }
        }
    }
}
