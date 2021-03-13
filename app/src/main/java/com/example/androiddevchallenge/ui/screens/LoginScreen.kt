package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.helpers.ROUTE_HOME_NAVIGATION_SCREEN
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(navController: NavController?) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        LoginMain(clickAction = { navController?.navigate(ROUTE_HOME_NAVIGATION_SCREEN) })
    }
}

@Composable
fun LoginMain(clickAction: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login with Email",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(
                bottom = 8.dp
            )
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email address", style = MaterialTheme.typography.body1) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    "Password (8+ characters)",
                    style = MaterialTheme.typography.body1
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = with(AnnotatedString.Builder("By clicking below, you agree to our ")) {
                pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                append("Terms of Use")
                pop()
                append(" and consent to our ")
                pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                append("Privacy Policy")
                addStyle(SpanStyle(color = MaterialTheme.colors.onPrimary), "Hello World".length, this.length)
                toAnnotatedString()
            },
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(
                bottom = 16.dp,
                top = 24.dp
            ),
            textAlign = TextAlign.Center,
        )
        Button(
            onClick = clickAction,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Log in", style = MaterialTheme.typography.button)
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        LoginScreen(navController = null)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        LoginScreen(navController = null)
    }
}