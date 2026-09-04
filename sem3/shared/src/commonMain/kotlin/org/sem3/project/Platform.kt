package org.sem3.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform