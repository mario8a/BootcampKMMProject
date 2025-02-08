package com.mariochoa.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.interop.LocalUIViewController
import platform.UIKit.UIAlertAction.Companion.actionWithTitle
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleActionSheet

@Composable
actual fun AppDialog(
    onConfirmed: () -> Unit,
    onDismissed: () -> Unit,
    message: String
) {
    val alert = UIAlertController.alertControllerWithTitle(
        title = "Te damos la bienvenida",
        message = "Hola $message",
        preferredStyle = UIAlertControllerStyleActionSheet
    )

    alert.addAction(
        actionWithTitle(title = "cancel", style = UIAlertActionStyleDefault, handler = { onDismissed() })
    )
    alert.addAction(
        actionWithTitle(title = "Confirm", style = UIAlertActionStyleDefault, handler = { onConfirmed() })
    )

    LocalUIViewController.current.showViewController(alert, null)
}