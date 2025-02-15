package com.mariochoa.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

actual abstract class AbstractViewModel {
    actual val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    actual fun dispose() {
        coroutineScope.cancel()
    }
}