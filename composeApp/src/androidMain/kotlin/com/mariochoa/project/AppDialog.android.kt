package com.mariochoa.project

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
actual fun AppDialog(
    onConfirmed: () -> Unit,
    onDismissed: () -> Unit,
    message: String
) {
    AlertDialog(
        title = { Text("Te damos la bienvenida") },
        text = {  Text("Hola $message") },
        onDismissRequest = {onDismissed() },
        confirmButton = {
            TextButton(
                onClick = { onConfirmed() }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismissed() }
            ) {
                Text("Dismiss")
            }
        }
    )
}