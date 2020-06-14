package basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


suspend fun hello() {
    delay(100)
    println("Hello")
}

fun main() {
    runBlocking {
        hello()
    }
}