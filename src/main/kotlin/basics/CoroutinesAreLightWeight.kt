package basics

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    val startTime = System.currentTimeMillis()

    runBlocking {

        repeat(1_000_000) {

            launch {

                print(".")
            }
        }
    }

    val endTime = System.currentTimeMillis()

    println("Total time taken: ${endTime - startTime}")
}