package demo

import kotlinx.coroutines.delay

fun main() {

}

private suspend fun doLongRunningTaskOne(): String {
    delay(3000)
    return "One"
}

private suspend fun doLongRunningTaskTwo(): String {
    delay(3000)
    return "Two"
}