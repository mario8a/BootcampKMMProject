package com.mariochoa.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import bootcampkmmproject.composeapp.generated.resources.Res
import bootcampkmmproject.composeapp.generated.resources.compose_multiplatform
import bootcampkmmproject.composeapp.generated.resources.fletelogo
import bootcampkmmproject.composeapp.generated.resources.week_days
import bootcampkmmproject.composeapp.generated.resources.welcome
import coil3.compose.AsyncImage
import com.mariochoa.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringArrayResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
        Surface(
            Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = stringResource(Res.string.welcome),
                    style = MaterialTheme.typography.displayLarge
                )
                Text(
                    text = "Do de noviembre 2",
                    style = MaterialTheme.typography.displayMedium
                )

                stringArrayResource(Res.array.week_days).forEach {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.displayMedium
                    )
                }
                Image(
                    painterResource(Res.drawable.fletelogo),
                    contentDescription = "Logo flete"
                )

                AsyncImage(
                    model = "https://kotlinlang.org/docs/images/kotlin-logo.png",
                    contentDescription = "Logo flete"
                )
                // recomposicion -> recrear el objeto
                var email by rememberSaveable { mutableStateOf("") }
                var password by rememberSaveable { mutableStateOf("") }
                var showDialog by rememberSaveable { mutableStateOf(false) }

                TextField(
                    modifier = Modifier.fillMaxWidth(),
//                    label = {
//                        Text("email")
//                    },
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    singleLine = true,
                    maxLines = 1,
                )
                TextField(
                    modifier = Modifier.fillMaxWidth(),
//                    label = {
//                        Text("email")
//                    },
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    singleLine = true,
                    maxLines = 1,
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        showDialog = true
                    }
                ) {
                    Text("Login")
                }

                if (showDialog) {
//                    AlertDialog(
//                        title = { Text("Te damos la bienvenida") },
//                        text = {  Text("Hola $email") },
//                        onDismissRequest = { },
//                        confirmButton = {
//                            TextButton(
//                                onClick = { showDialog = false }
//                            ) {
//                                Text("Confirm")
//                            }
//                        },
//                        dismissButton = {
//                            TextButton(
//                                onClick = { showDialog = false }
//                            ) {
//                                Text("Dismiss")
//                            }
//                        }
//                    )
                    AppDialog(
                        onConfirmed = { showDialog = false },
                        onDismissed = { showDialog = false },
                        message = email
                    )
                }


            }
        }
    }
}