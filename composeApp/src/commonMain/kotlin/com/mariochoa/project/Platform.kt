package com.mariochoa.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform