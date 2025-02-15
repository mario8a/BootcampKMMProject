package com.mariochoa.presentation

import kotlinx.coroutines.CoroutineScope

expect abstract class AbstractViewModel() {
    val coroutineScope: CoroutineScope
    fun dispose()

}