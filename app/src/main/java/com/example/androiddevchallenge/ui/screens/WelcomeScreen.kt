package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.helpers.ROUTE_LOGIN_SCREEN
import com.example.androiddevchallenge.ui.components.ReusableImage
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(navController: NavController?) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
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
                                .offset(56.dp)
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


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WelcomeScreen(navController = null)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(navController = null)
    }
}
