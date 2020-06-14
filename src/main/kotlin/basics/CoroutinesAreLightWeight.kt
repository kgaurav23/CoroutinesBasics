package basics

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val startTime = System.currentTimeMillis()

    // create 1_000_000 coroutines and print "."
    runBlocking {
        repeat(1_000_000) {
            launch {
                print(".")
            }
        }
    }

    val endTime = System.currentTimeMillis()

    println()
    println("Total time taken: ${endTime - startTime} ms")
}