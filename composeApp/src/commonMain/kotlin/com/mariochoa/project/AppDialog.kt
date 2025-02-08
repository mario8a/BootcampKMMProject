package com.mariochoa.project

import androidx.compose.runtime.Composable
// La funcion es una interfaz que se implementa en cada plataforma
@Composable
expect fun AppDialog(
    onConfirmed: () -> Unit,
    onDismissed: () -> Unit,
    message: String
)