package flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import java.lang.Exception

fun main() {
    runBlocking {
        catchOperator()
    }
}

// Catches any exception that occurs above catch operator not below
suspend fun catchOperator() {

    try {
        (1..3).asFlow()
            .onEach { check(it != 2)}
            .catch { e -> println("Caught Exception: $e") }
            .collect { println(it) }
    } catch (ex: Exception) {
        println("Caught Exception: $ex")
    }
}

suspend fun tryCatch() {

    try {
        (1..3).asFlow()
            .onEach { check(it != 2)}
            .collect { println(it) }
    } catch (ex: Exception) {
        println("Caught Exception: $ex")
    }
}