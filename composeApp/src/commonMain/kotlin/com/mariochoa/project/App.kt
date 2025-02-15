package com.mariochoa.project

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.mariochoa.presentation.goal.AddGoalScreen
import com.mariochoa.presentation.home.HomeScreen
import com.mariochoa.theme.AppTheme
import com.mariochoa.views.AddHabitView
import com.mariochoa.views.HomeView
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
//        AddHabitView()
//        AddGoalScreen()
        Navigator(AddGoalScreen())

//        Surface(
//            Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Column(
//                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
//            ) {
//                Text(
//                    text = stringResource(Res.string.welcome),
//                    style = MaterialTheme.typography.displayLarge
//                )
//                Text(
//                    text = "Do de noviembre 2",
//                    style = MaterialTheme.typography.displayMedium
//                )
//
//                stringArrayResource(Res.array.week_days).forEach {
//                    Text(
//                        text = it,
//                        style = MaterialTheme.typography.displayMedium
//                    )
//                }
//                Image(
//                    painterResource(Res.drawable.fletelogo),
//                    contentDescription = "Logo flete"
//                )
//
//                AsyncImage(
//                    model = "https://kotlinlang.org/docs/images/kotlin-logo.png",
//                    contentDescription = "Logo flete"
//                )
//                // recomposicion -> recrear el objeto
//                var email by rememberSaveable { mutableStateOf("") }
//                var password by rememberSaveable { mutableStateOf("") }
//                var showDialog by rememberSaveable { mutableStateOf(false) }
//
//                TextField(
//                    modifier = Modifier.fillMaxWidth(),
////                    label = {
////                        Text("email")
////                    },
//                    value = email,
//                    onValueChange = {
//                        email = it
//                    },
//                    singleLine = true,
//                    maxLines = 1,
//                )
//                TextField(
//                    modifier = Modifier.fillMaxWidth(),
////                    label = {
////                        Text("email")
////                    },
//                    value = password,
//                    onValueChange = {
//                        password = it
//                    },
//                    singleLine = true,
//                    maxLines = 1,
//                )
//
//                Button(
//                    modifier = Modifier.fillMaxWidth(),
//                    onClick = {
//                        showDialog = true
//                    }
//                ) {
//                    Text("Login")
//                }
//
//                if (showDialog) {
////                    AlertDialog(
////                        title = { Text("Te damos la bienvenida") },
////                        text = {  Text("Hola $email") },
////                        onDismissRequest = { },
////                        confirmButton = {
////                            TextButton(
////                                onClick = { showDialog = false }
////                            ) {
////                                Text("Confirm")
////                            }
////                        },
////                        dismissButton = {
////                            TextButton(
////                                onClick = { showDialog = false }
////                            ) {
////                                Text("Dismiss")
////                            }
////                        }
////                    )
//                    AppDialog(
//                        onConfirmed = { showDialog = false },
//                        onDismissed = { showDialog = false },
//                        message = email
//                    )
//                }
//
//
//            }
//        }
    }
}